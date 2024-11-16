<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cập Nhật Màu Sắc</title>
    <!-- Thêm Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Cập Nhật Màu Sắc</h2>
    <form action="/mausac/update" method="post">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="number" name="id" value="${mauSac.id}" class="form-control" id="id" readonly>
        </div>
        <div class="form-group">
            <label for="ma">Mã:</label>
            <input type="text" name="ma" value="${mauSac.ma}" class="form-control" id="ma">
        </div>
        <div class="form-group">
            <label for="ten">Tên:</label>
            <input type="text" name="ten" value="${mauSac.ten}" class="form-control" id="ten">
        </div>
        <div class="form-group">
            <label>Trạng thái:</label><br>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="true" ${mauSac.trangThai ? "checked" :""}>
                <label class="form-check-label">Hiệu lực</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="false" ${mauSac.trangThai ? "" :"checked"}>
                <label class="form-check-label">Không hiệu lực</label>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="/mausac/show" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<!-- Thêm Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
