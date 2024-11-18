<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
    <link rel="stylesheet" href="style.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .btn-custom {
            width: 200px;
            margin: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-custom:hover {
            transform: scale(1.05);
            transition: transform 0.3s ease;
        }

        /* Tùy chỉnh nút điều hướng của carousel */
        .carousel-control-prev-icon,
        .carousel-control-next-icon {
            background-color: #000;
            border-radius: 50%;
            padding: 10px;
        }

        .carousel-control-prev-icon:hover,
        .carousel-control-next-icon:hover {
            background-color: #555;
        }

        /* Tùy chỉnh ảnh trong carousel */
        .carousel-inner img {
            height: 400px;
            object-fit: cover;
        }

        /* Hiệu ứng chuyển động mượt cho slide */
        .carousel-item {
            transition: transform 0.8s ease-in-out;
        }

        .carousel {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        /* Định dạng lại nút điều khiển */
        .carousel-control-prev,
        .carousel-control-next {
            width: 5%;
        }
    </style>

    <title>Buoi 2</title>
</head>

<body>
<div class="container-fluid" style="padding: 0">
    <!-- header -->
    <header class="d-flex justify-content-center" style="height: 100px">
        <img style="height: 100px" src="https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png"
             alt="" />
    </header>
    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="https://images2.thanhnien.vn/528068263637045248/2024/1/25/e093e9cfc9027d6a142358d24d2ee350-65a11ac2af785880-17061562929701875684912.jpg" class="d-block w-100" alt="Image 1">
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="https://png.pngtree.com/background/20230519/original/pngtree-treed-reflections-at-a-sunset-hd-picture-image_2653276.jpg" class="d-block w-100" alt="Image 2">
            </div>
            <div class="carousel-item">
                <img src="https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg" class="d-block w-100" alt="Image 3">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>


    <nav>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <span> <i class="bi bi-house"></i> </span>Trang chủ</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#"><span><i
                                    class="bi bi-envelope"></i></span>Liên hệ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span><i class="bi bi-arrow-up-right-square-fill"></i></span>Góp ý</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span><i class="bi bi-question"></i></span>Hỏi đáp</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                <span><i class="bi bi-person-fill"></i></span>
                                Tài khoản
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Đăng nhập</a></li>
                                <li><a class="dropdown-item" href="#">Đăng ký</a></li>
                                <li><a class="dropdown-item" href="#">Quên mật khẩu</a></li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li><a class="dropdown-item" href="#">Hồ sơ cá nhân</a></li>
                                <li><a class="dropdown-item" href="#">Đổi mật khẩu</a></li>
                                <li><a class="dropdown-item" href="#">Đăng xuất</a></li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li><a class="dropdown-item" href="#">Đơn đặt hàng</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- menu phải -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#"> <span><i
                                    class="bi bi-star-fill"></i></span>Tiếng Việt</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span><i class="bi bi-currency-dollar"></i></span>English</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </nav>

    <main class="row">

        <!-- 1. bên trái -->
        <aside class="col-2" style="height: 500px;">
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-action list-group-item-primary disable">
                    <i class="bi bi-backpack-fill"></i> CHỨC NĂNG
                </a>

                <!-- Dropdown Quản lý sản phẩm -->
                <div class="dropdown">
                    <a class="list-group-item list-group-item-action list-group-item-light dropdown-toggle"
                       href="#" role="button" id="dropdownSanPham"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Quản lý sản phẩm
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownSanPham">
                        <li><a class="dropdown-item" href="/sanpham/show">Sản phẩm</a></li>
                        <li><a class="dropdown-item" href="/sanphamchitiet/show">Sản phẩm chi tiết</a></li>
                        <li><a class="dropdown-item" href="/mausac/show">Màu sắc</a></li>
                        <li><a class="dropdown-item" href="/kichthuoc/show">Kích thước</a></li>
                    </ul>
                </div>

                <!-- Dropdown Quản lý khác -->
                <div class="dropdown">
                    <a class="list-group-item list-group-item-action list-group-item-light dropdown-toggle"
                       href="#" role="button" id="dropdownQuanLy"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Quản lý hệ thống
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownQuanLy">
                        <li><a class="dropdown-item" href="/nhanvien/show">Nhân viên</a></li>
                        <li><a class="dropdown-item" href="/khachhang/show">Khách hàng</a></li>
                        <li><a class="dropdown-item" href="/hoadon/show">Hóa đơn</a></li>
                        <li><a class="dropdown-item" href="/hoadonchitiet/show">Hóa đơn chi tiết</a></li>
                    </ul>
                </div>

                <!-- Quản lý bán hàng (không cần dropdown) -->
                <a href="/banhang/hien-thi" class="list-group-item list-group-item-action list-group-item-light">Quản lý bán hàng</a>
            </div>
        </aside>

    </main>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
