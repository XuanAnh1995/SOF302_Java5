<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách Nhân Viên</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <form action="/nhanvien/search" method="get">
        Mã nhân viên:
        <input type="text" name="maNV">
        <button type="submit">Search</button>
    </form>
    <br>
    <a href="/nhanvien/add">Thêm nhân viên</a>
    <br>
    <h2 class="mb-4">Danh sách Nhân Viên</h2>

    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Mã Nhân Viên</th>
            <th>Tên Đăng Nhập</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list_NhanVien}" var="nhanVien">
            <tr>
                <td>${nhanVien.id}</td>
                <td>${nhanVien.ten}</td>
                <td>${nhanVien.maNV}</td>
                <td>${nhanVien.tenDangNhap}</td>
                <td>${nhanVien.trangThai ? "Đang làm việc" : "Nghỉ việc"}</td>
                <td>
                    <a href="/nhanvien/delete/${nhanVien.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/nhanvien/detail?id=${nhanVien.id}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <a href="/nhanvien/show?page=0">First</a>
        <a href="/nhanvien/show?page=${currentPage > 0 ? currentPage - 1 : 0}"> << </a>
        <span>${currentPage + 1} / ${totalPages}</span>
        <a href="/nhanvien/show?page=${currentPage < totalPages - 1 ? currentPage + 1 : totalPages - 1}"> >> </a>
        <a href="/nhanvien/show?page=${totalPages - 1}">Last</a>
    </div>
    <br>
    <a href="/main" class="btn btn-secondary">Quay lại</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
