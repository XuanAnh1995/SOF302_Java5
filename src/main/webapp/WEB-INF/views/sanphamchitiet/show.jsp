<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh sách Sản Phẩm Chi Tiết</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 30px;
        }
    </style>
</head>
<body>

<div class="container">
    <form action="/sanphamchitiet/search" method="get">
        <input type="text" name="maSPCT">
        <button type="submit">Search</button>
    </form>
    <br>
    <a href="/sanphamchitiet/add">Thêm sản phẩm chi tiết</a>
    <br>
    <h2 class="text-center text-primary">Danh sách Sản Phẩm Chi Tiết</h2>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Mã SPCT</th>
            <th>ID Màu Sắc</th>
            <th>ID Kích Thước</th>
            <th>ID Sản Phẩm</th>
            <th>Số Lượng</th>
            <th>Giá</th>
            <th>Trạng thái</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_SanPhamChiTiet}" var="sanPhamChiTiet">
            <tr>
                <td>${sanPhamChiTiet.id}</td>
                <td>${sanPhamChiTiet.maSPCT}</td>
                <td>${sanPhamChiTiet.mauSac.id}</td>
                <td>${sanPhamChiTiet.kichThuoc.id}</td>
                <td>${sanPhamChiTiet.sanPham.id}</td>
                <td>${sanPhamChiTiet.soLuong}</td>
                <td>${sanPhamChiTiet.donGia}</td>
                <td>${sanPhamChiTiet.trangThai ? "Còn hàng" : "Hết hàng"}</td>
                <td>
                    <a href="/sanphamchitiet/detail?id=${sanPhamChiTiet.id}" class="btn btn-info btn-sm">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
