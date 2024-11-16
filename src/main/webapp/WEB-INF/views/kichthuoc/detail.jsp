<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chi tiết Kích Thước</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Chi tiết Kích Thước</h2>
    <form action="/kichthuoc/update" method="post">
        <div class="form-group">
            <label>ID:</label>
            <input type="number" name="id" value="${kichThuoc.id}" class="form-control" readonly>
        </div>
        <div class="form-group">
            <label>Mã:</label>
            <input type="text" name="ma" value="${kichThuoc.ma}" class="form-control">
        </div>
        <div class="form-group">
            <label>Tên:</label>
            <input type="text" name="ten" value="${kichThuoc.ten}" class="form-control">
        </div>
        <div class="form-group">
            <label>Trạng thái:</label><br>
            <div class="form-check form-check-inline">
                <input type="radio" name="trangThai" value="true" class="form-check-input" ${kichThuoc.trangThai ? "checked" : ""}>
                <label class="form-check-label">Hiệu lực</label>
            </div>
            <div class="form-check form-check-inline">
                <input type="radio" name="trangThai" value="false" class="form-check-input" ${kichThuoc.trangThai ? "" : "checked"}>
                <label class="form-check-label">Không hiệu lực</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="/kichthuoc/show" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
