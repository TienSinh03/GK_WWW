/**
 * @ (#) TinTuc.java      10/25/2024
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
@Table(name = "tintuc")
public class TinTuc
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tieuDe;
    private String noiDungTT;
    private String lienKet;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ma_danh_muc")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(long id, String tieuDe, String noiDungTT, String lienKet) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
    }

    public TinTuc(String tieuDe, String noiDungTT, String lienKet) {
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDungTT() {
        return noiDungTT;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
