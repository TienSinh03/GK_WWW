/**
 * @ (#) IQLTinTucServices.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.DanhMuc;
import vn.edu.iuh.fit.models.TinTuc;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
public interface IQLTinTucServices {
    public List<TinTuc> getListTintuc();
    public TinTuc getTintuc(long id);

    public boolean save(TinTuc tintuc, long idDanhMuc);
    public boolean update(TinTuc tintuc, long idDanhMuc);
    public boolean delete(long id);

    public List<DanhMuc> getListDanhMuc();
    public DanhMuc getDanhMuc(long id);

}
