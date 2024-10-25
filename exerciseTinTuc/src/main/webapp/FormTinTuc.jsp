<%@ page import="vn.edu.iuh.fit.models.DanhMuc" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.models.TinTuc" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/25/2024
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Form</title>
</head>
<body>
<%
    String action = request.getParameter("action");
    TinTuc tinTuc = (TinTuc) session.getAttribute("tinTuc");
    DanhMuc danhMuc = (DanhMuc) session.getAttribute("danhMuc");

    long maTin = tinTuc.getId() == 0 ? 0 : tinTuc.getId();
    String tieuDe = tinTuc.getTieuDe() == null ? "" : tinTuc.getTieuDe();
    String noiDungTT = tinTuc.getNoiDungTT() == null ? "" : tinTuc.getNoiDungTT();
    String lienKet = tinTuc.getLienKet() == null ? "" : tinTuc.getLienKet();
    String tenDanhMuc = danhMuc.getTenDanhMuc() == null ? "" : danhMuc.getTenDanhMuc();

    List<DanhMuc> danhMucList = (List<DanhMuc>) session.getAttribute("danhMucList");
%>
<div class="container">
  <h1 class="text-center mb-3">Form</h1>
  <form action="controller" method="post">
      <input type="hidden" name="action" value="<%=action%>">
    <div class="mb-3">
        <label for="maTin">Mã Tin Tuc</label>
        <input type="text" class="form-control" id="maTin" name="maTin" value="<%=maTin%>" readonly>
    </div>

      <div class="mb-3">
          <label for="tieuDe">Tiêu Đề</label>
          <input type="text" class="form-control" id="tieuDe" name="tieuDe" value="<%=tieuDe%>" >
      </div>

      <div class="mb-3">
          <label for="noiDungTT">Nội Dung</label>
          <input type="text" class="form-control" id="noiDungTT" name="noiDungTT" value="<%=noiDungTT%>">
      </div>

      <div class="mb-3">
          <label for="lienKet">Liên Kết</label>
          <input type="text" class="form-control" id="lienKet" name="lienKet" value="<%=lienKet%>">
      </div>

        <div class="mb-3">
            <label for="danhMuc">Danh mục</label>
            <select class="form-select" id="danhMuc" name="danhMuc">
                 <%
                    for (DanhMuc dMuc : danhMucList) {
                 %>
                    <option value="<%=dMuc.getId()%>" <%=dMuc.getTenDanhMuc().equals(tenDanhMuc) ? "selected" : ""%> > <%=dMuc.getTenDanhMuc()%></option>
                    <%
                        }
                    %>

            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="index.jsp" class="btn btn-secondary">Cancel</a>
  </form>
</div>
</body>
</html>
