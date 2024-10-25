/**
 * @ (#) ServletController.java      10/25/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.controller;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.models.DanhMuc;
import vn.edu.iuh.fit.models.TinTuc;
import vn.edu.iuh.fit.services.IQLTinTucServices;
import vn.edu.iuh.fit.services.impl.QlTinTucServicesImpl;

import java.io.IOException;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 10/25/2024
 */
@WebServlet(name = "ServletController", value = "/controller")
public class ServletController extends HttpServlet {

    private final IQLTinTucServices qlTinTucServices;

    public ServletController() {
        this.qlTinTucServices = new QlTinTucServicesImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);
        if(action.equalsIgnoreCase("dstinTuc")) {
            List<TinTuc> listTintuc = qlTinTucServices.getListTintuc();
            session.setAttribute("listNews", listTintuc);
            req.getRequestDispatcher("ListTinTuc.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("themTinTuc")) {
            List<DanhMuc> listDanhMuc = qlTinTucServices.getListDanhMuc();
            session.setAttribute("danhMucList", listDanhMuc);
            session.setAttribute("tinTuc", new TinTuc());
            session.setAttribute("danhMuc", new DanhMuc());
            req.getRequestDispatcher("FormTinTuc.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("edit")) {

            long id = Long.parseLong(req.getParameter("id"));
            TinTuc tinTuc = qlTinTucServices.getTintuc(id);
            session.setAttribute("danhMucList", qlTinTucServices.getListDanhMuc());
            session.setAttribute("tinTuc", tinTuc);
            session.setAttribute("danhMuc", tinTuc.getDanhMuc());
            req.getRequestDispatcher("FormTinTuc.jsp").forward(req, resp);
        } else if(action.equalsIgnoreCase("delete")) {
            long id = Long.parseLong(req.getParameter("id"));
            boolean result = qlTinTucServices.delete(id);

            if(result)
                resp.sendRedirect("controller?action=dstinTuc");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String maTinTuc = req.getParameter("maTin");
        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDungTT");
        String lienKet = req.getParameter("lienKet");
        String maDanhMuc = req.getParameter("danhMuc");

        if(action.equalsIgnoreCase("themTinTuc")){
            TinTuc tinTuc = new TinTuc(tieuDe, noiDung, lienKet);
            boolean result = qlTinTucServices.save(tinTuc, Long.parseLong(maDanhMuc));
            if(result)
                resp.sendRedirect("controller?action=dstinTuc");
        } else if(action.equalsIgnoreCase("edit")) {
            TinTuc tinTuc = new TinTuc(Long.parseLong(maTinTuc), tieuDe, noiDung, lienKet);
            boolean result = qlTinTucServices.update(tinTuc, Long.parseLong(maDanhMuc));
            if(result)
                resp.sendRedirect("controller?action=dstinTuc");
        }
    }
}
