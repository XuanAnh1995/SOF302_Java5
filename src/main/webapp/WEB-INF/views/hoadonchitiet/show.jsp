<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh sách Hóa Đơn Chi Tiết</title>
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
    <div class="form-container">
        <h2 class="text-center text-primary">Chi tiết Hóa Đơn Chi Tiết</h2>
        <form>
            <div class="form-group">
                <label for="id">ID:</label>
                <input type="number" class="form-control" id="id" name="id" value="${hoaDonChiTiet.id}" readonly>
            </div>
            <div class="form-group">
                <label for="idHoaDon">ID Hóa Đơn:</label>
                <input type="number" class="form-control" id="idHoaDon" name="idHoaDon" value="${hoaDonChiTiet.hoaDon.id}" readonly>
            </div>
            <div class="form-group">
                <label for="idSPCT">Sản Phẩm Chi Tiết:</label>
                <input type="number" class="form-control" id="idSPCT" name="idSPCT" value="${hoaDonChiTiet.sanPhamChiTiet.id}" readonly>
            </div>
            <div class="form-group">
                <label for="soLuong">Số Lượng:</label>
                <input type="number" class="form-control" id="soLuong" name="soLuong" value="${hoaDonChiTiet.soLuong}" readonly>
            </div>
            <div class="form-group">
                <label for="donGia">Đơn Giá:</label>
                <input type="number" class="form-control" id="donGia" name="donGia" value="${hoaDonChiTiet.donGia}" step="0.01" readonly>
            </div>
            <div class="form-group">
                <label>Trạng thái:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="hoanThanh" value="true" ${hoaDonChiTiet.trangThai ? "checked" : ""} disabled>
                    <label class="form-check-label" for="hoanThanh">Hoàn thành</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="trangThai" id="chuaHoanThanh" value="false" ${hoaDonChiTiet.trangThai ? "" : "checked"} disabled>
                    <label class="form-check-label" for="chuaHoanThanh">Chưa hoàn thành</label>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="container">
    <h2 class="text-center text-primary">Danh sách Hóa Đơn Chi Tiết</h2>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>ID Hóa Đơn</th>
            <th>Sản Phẩm Chi Tiết</th>
            <th>Số Lượng</th>
            <th>Đơn Giá</th>
            <th>Trạng thái</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_HoaDonChiTiet}" var="hoaDonChiTiet">
            <tr>
                <td>${hoaDonChiTiet.id}</td>
                <td>${hoaDonChiTiet.hoaDon.id}</td>
                <td>${hoaDonChiTiet.sanPhamChiTiet.id}</td>
                <td>${hoaDonChiTiet.soLuong}</td>
                <td>${hoaDonChiTiet.donGia}</td>
                <td>${hoaDonChiTiet.trangThai ? "Hoàn thành" : "Chưa hoàn thành"}</td>
                <td>
                    <a href="/hoadonchitiet/detail?id=${hoaDonChiTiet.id}" class="btn btn-info btn-sm">Detail</a>
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
