<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết Khách Hàng</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Chi tiết Khách Hàng</h2>
    <form action="/khachhang/update" method="post">
        <div class="form-group">
            <label>ID:</label>
            <input type="number" name="id" value="${khachHang.id}" class="form-control" readonly>
        </div>
        <div class="form-group">
            <label>Tên:</label>
            <input type="text" name="ten" value="${khachHang.ten}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Số Điện Thoại:</label>
            <input type="text" name="sdt" value="${khachHang.sdt}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Mã Khách Hàng:</label>
            <input type="text" name="maKH" value="${khachHang.maKH}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>Trạng thái:</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" name="trangThai" value="true" class="form-check-input" ${khachHang.trangThai ? "checked" : ""}>
                <label class="form-check-label">Đang hoạt động</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" name="trangThai" value="false" class="form-check-input" ${khachHang.trangThai ? "" : "checked"}>
                <label class="form-check-label">Ngừng hoạt động</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="/khachhang/show" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
