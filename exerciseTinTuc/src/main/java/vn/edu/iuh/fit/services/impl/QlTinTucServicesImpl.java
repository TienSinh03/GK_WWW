/**
 * @ (#) QlTinTucServicesImpl.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.services.impl;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.DanhMuc;
import vn.edu.iuh.fit.models.TinTuc;
import vn.edu.iuh.fit.repositories.IDanhSachTinTucQuanLy;
import vn.edu.iuh.fit.repositories.impl.DanhSachTinTucQlImpl;
import vn.edu.iuh.fit.services.IQLTinTucServices;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
public class QlTinTucServicesImpl implements IQLTinTucServices {

    private final IDanhSachTinTucQuanLy danhSachTinTucQuanLy;

    public QlTinTucServicesImpl() {
        danhSachTinTucQuanLy = new DanhSachTinTucQlImpl();
    }
    @Override
    public List<TinTuc> getListTintuc() {
        return danhSachTinTucQuanLy.findAll();
    }

    @Override
    public TinTuc getTintuc(long id) {
        return danhSachTinTucQuanLy.findById(id);
    }

    @Override
    public boolean save(TinTuc tintuc, long idDanhMuc) {
        DanhMuc danhMuc = danhSachTinTucQuanLy.getDanhMucById(idDanhMuc);
        tintuc.setDanhMuc(danhMuc);
        return danhSachTinTucQuanLy.save(tintuc);
    }

    @Override
    public boolean update(TinTuc tintuc, long idDanhMuc) {
        DanhMuc danhMuc = danhSachTinTucQuanLy.getDanhMucById(idDanhMuc);
        tintuc.setDanhMuc(danhMuc);
        return danhSachTinTucQuanLy.update(tintuc);
    }

    @Override
    public boolean delete(long id) {
        return danhSachTinTucQuanLy.delete(id);
    }

    @Override
    public List<DanhMuc> getListDanhMuc() {
        return danhSachTinTucQuanLy.getAllDanhMuc();
    }

    @Override
    public DanhMuc getDanhMuc(long id) {
        return danhSachTinTucQuanLy.getDanhMucById(id);
    }

    public static void main(String[] args) {
        QlTinTucServicesImpl qlTinTucServices = new QlTinTucServicesImpl();
        List<DanhMuc> listTintuc = qlTinTucServices.getListDanhMuc();
        for (DanhMuc DanhMuc : listTintuc) {
            System.out.println(DanhMuc.getTenDanhMuc());
        }
    }
}
