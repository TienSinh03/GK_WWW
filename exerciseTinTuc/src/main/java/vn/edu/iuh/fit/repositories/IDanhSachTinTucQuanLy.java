/**
 * @ (#) IDanhSachTinTucQuanLy.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.DanhMuc;
import vn.edu.iuh.fit.models.TinTuc;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
public interface IDanhSachTinTucQuanLy {
    public List<TinTuc> findAll();
    public boolean save(TinTuc tinTuc);
    public boolean update(TinTuc tinTuc);
    public boolean delete(long id);

    public TinTuc findById(long id);

    public List<DanhMuc> getAllDanhMuc();
    public DanhMuc getDanhMucById(long id);
    public DanhMuc getDanhMucByTinTuc(long id);
}
