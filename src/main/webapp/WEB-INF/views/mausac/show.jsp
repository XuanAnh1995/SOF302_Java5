<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Màu Sắc</title>
    <!-- Thêm Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <form action="/mausac/search" method="get">
        <input name="ma" type="text">
        <button type="submit">Search</button>
    </form>
    <br>
    <a href="/mausac/add">Thêm màu sắc</a>
    <br>
    <br>
    <h2>Danh sách màu sắc</h2>
    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_MauSac}" var="mauSac">
            <tr>
                <td>${mauSac.id}</td>
                <td>${mauSac.ma}</td>
                <td>${mauSac.ten}</td>
                <td>${mauSac.trangThai ? "Hiệu lực" : "Không hiệu lực"}</td>
                <td>
                    <a href="/mausac/delete/${mauSac.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/mausac/detail?id=${mauSac.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Phân trang-->
    <div class="pagination">
        <a href="/mausac/show?page=0">First</a> &nbsp;
        <a href="/mausac/show?page=${currentPage > 0 ? currentPage - 1 : 0}"> << </a>
        <span>${currentPage + 1} / ${totalPages}</span> &nbsp;
        <a href="/mausac/show?page=${currentPage < totalPages - 1 ? currentPage + 1 : totalPages - 1}"> >> </a>
        <a href="/mausac/show?page=${totalPages - 1}">Last </a>
    </div>
    <br>

    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>

<!-- Thêm Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
