/**
 * @ (#) DanhSachTinTucQlImpl.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.models.DanhMuc;
import vn.edu.iuh.fit.models.TinTuc;
import vn.edu.iuh.fit.repositories.IDanhSachTinTucQuanLy;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
public class DanhSachTinTucQlImpl implements IDanhSachTinTucQuanLy {
    private EntityManager entityManager;
    private EntityTransaction et;

    public DanhSachTinTucQlImpl() {
        entityManager = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = entityManager.getTransaction();
    }

    @Override
    public List<TinTuc> findAll() {
        String query = "SELECT t FROM TinTuc t";
        return entityManager.createQuery(query, TinTuc.class).getResultList();
    }

    @Override
    public boolean save(TinTuc tinTuc) {
        try {
            et.begin();
            entityManager.persist(tinTuc);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(TinTuc tinTuc) {
        try {
            et.begin();
            entityManager.merge(tinTuc);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM TinTuc t WHERE t.id = :id";
        try {
            et.begin();
            entityManager.createQuery(query).setParameter("id", id).executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TinTuc findById(long id) {
        return entityManager.find(TinTuc.class, id);
    }

    @Override
    public List<DanhMuc> getAllDanhMuc() {
        String query = "SELECT d FROM DanhMuc d";
        return entityManager.createQuery(query, DanhMuc.class).getResultList();
    }

    @Override
    public DanhMuc getDanhMucById(long id) {
        return entityManager.find(DanhMuc.class, id);
    }

    @Override
    public DanhMuc getDanhMucByTinTuc(long id) {
       return null;
    }

}
