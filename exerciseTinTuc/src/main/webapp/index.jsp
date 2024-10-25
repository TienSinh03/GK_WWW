<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Dashboard</title>
</head>
<body>
    <div class="container border border-secondary">
        <img src="https://thumbs.dreamstime.com/z/good-news-banner-colorful-confetti-paper-vector-background-126038120.jpg" class="img-fluid" alt="tinTuc">
        <h1 class="text-center border-top">Welcome to the dashboard of the news!</h1>
        <div class="row border border-top">
            <div class="d-flex justify-content-center mb-2 mt-2">
                <a href="controller?action=dstinTuc" class="btn btn-primary me-4">Danh sách tin tức</a>
                <a href="controller?action=themTinTuc" class="btn btn-primary">Thêm tin tức mới</a>
            </div>
        </div>
    </div>
</body>
</html>