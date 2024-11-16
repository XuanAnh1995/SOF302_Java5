<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Sản Phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <form action="/sanpham/search" method="get">
        <input type="text" name="ma">
        <button type="submit">Search</button>
    </form>
    <br>
    <a href="/sanpham/add">Thêm sản phẩm</a>
    <br>
    <h2 class="mb-4">Danh sách Sản Phẩm</h2>

    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_SanPham}" var="sanPham">
            <tr>
                <td>${sanPham.id}</td>
                <td>${sanPham.ma}</td>
                <td>${sanPham.ten}</td>
                <td>${sanPham.trangThai ? "Còn hàng" : "Hết hàng"}</td>
                <td>
                    <a href="/sanpham/delete/${sanPham.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/sanpham/detail?id=${sanPham.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <a href="/sanpham/show?page=0">First</a>
        <a href="/sanpham/show?page=${currentPage > 0 ? currentPage - 1 : 0}"> << </a>
        <span>${currentPage + 1} / ${totalPages}</span>
        <a href="/sanpham/show?page=${currentPage < totalPage -1 ? currentPage + 1 : totalPages - 1}"> >> </a>
        <a href="/sanpham/show?page=${totalPages - 1}">Last</a>
    </div>
    <br>
    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
