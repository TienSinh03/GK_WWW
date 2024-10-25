<%@ page import="vn.edu.iuh.fit.models.TinTuc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phant
  Date: 10/25/2024
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Danh Sach Tin Tuc</title>
</head>
<body>
<%
    List<TinTuc> listTinTuc = (List<TinTuc>) session.getAttribute("listNews");
%>
<div class="container">
    <h1 class="text-center">Danh Sach Tin Tuc</h1>
    <a href="index.jsp" class="btn btn-outline-secondary mb-4">Back to Dashboard</a>
    <a href="controller?action=themTinTuc" class="btn btn-outline-primary mb-4">Thêm Tin Tức</a>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Ma Tin Tức</th>
            <th>Tiêu Đề</th>
            <th>Nội Dung</th>
            <th>Liên Kết</th>
            <th>Danh Mục</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(TinTuc news : listTinTuc){
        %>
            <tr>
                <td><%=news.getId()%></td>
                <td><%=news.getTieuDe()%></td>
                <td><%=news.getNoiDungTT()%></td>
                <td><%=news.getLienKet()%></td>
                <td><%=news.getDanhMuc().getTenDanhMuc()%></td>
                <td>
                    <a href="controller?action=edit&id=<%=news.getId()%>" class="btn btn-outline-primary me-4">Sửa</a>
                    <a href="controller?action=delete&id=<%=news.getId()%>" class="btn btn-outline-danger">Xóa</a>
                </td>
            </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
