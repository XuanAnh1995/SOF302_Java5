<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh sách Kích Thước</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <form action="/kichthuoc/search" method="get">
        <input name="ma" type="text">
        <button type="submit">Search</button>
    </form>

    <a href="/kichthuoc/add">Thêm kích thước</a>
    <h2 class="mb-4">Danh sách Kích Thước</h2>


    <table class="table table-bordered" border="1">
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
        <c:forEach items="${list_KichThuoc}" var="kichThuoc">
            <tr>
                <td>${kichThuoc.id}</td>
                <td>${kichThuoc.ma}</td>
                <td>${kichThuoc.ten}</td>
                <td>${kichThuoc.trangThai ? "Hiệu lực" : "Không hiệu lực"}</td>
                <td>
                    <a href="/kichthuoc/delete/${kichThuoc.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/kichthuoc/detail?id=${kichThuoc.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Phân trang -->
    <div class="pagination">
        <a href="/kichthuoc/show?page=0">Fist</a>
        <a href="/kichthuoc/show?page=${currentPage > 0 ? currentPage - 1 : 0}"> << </a>
        <span>${currentPage + 1} / ${totalPages} </span>
        <a href="/kichthuoc/show?page=${currentPage < totalPages - 1 ? currentPage + 1 : totalPages - 1}"> >> </a>
        <a href="/kichthuoc/show?page=${totalPages - 1}">Last</a>
    </div>
    <br>
    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
