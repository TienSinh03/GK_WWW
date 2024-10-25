/**
 * @ (#) DanhMuc.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
@Entity
@Table(name = "danhmuc")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tenDanhMuc;
    private String nguoiQL;
    private String ghiChu;

    public DanhMuc() {
    }

    public DanhMuc(String tenDanhMuc, String nguoiQL, String ghiChu) {
        this.tenDanhMuc = tenDanhMuc;
        this.nguoiQL = nguoiQL;
        this.ghiChu = ghiChu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getNguoiQL() {
        return nguoiQL;
    }

    public void setNguoiQL(String nguoiQL) {
        this.nguoiQL = nguoiQL;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
