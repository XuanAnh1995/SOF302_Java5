<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="styles.css"> <!-- Thêm đường dẫn tới file CSS của bạn -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #eef2f3; /* Màu nền nhẹ nhàng */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background: white;
            padding: 30px; /* Tăng không gian đệm */
            border-radius: 12px; /* Bo tròn góc */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Bóng đổ nhẹ */
            width: 320px; /* Chiều rộng cố định */
            text-align: center; /* Căn giữa nội dung */
        }
        h2 {
            margin-bottom: 20px; /* Khoảng cách dưới tiêu đề */
            color: #333; /* Màu tiêu đề */
        }
        div {
            margin-bottom: 15px; /* Khoảng cách giữa các trường nhập */
        }
        label {
            display: block;
            margin-bottom: 5px; /* Khoảng cách dưới nhãn */
            color: #555; /* Màu nhãn */
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px; /* Tăng kích thước không gian nhập */
            border: 1px solid #ccc; /* Đường viền nhẹ */
            border-radius: 4px; /* Bo tròn góc */
            font-size: 14px; /* Kích thước chữ */
            transition: border-color 0.3s; /* Hiệu ứng chuyển tiếp cho đường viền */
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007BFF; /* Đổi màu viền khi tập trung vào trường nhập */
            outline: none; /* Tắt viền mặc định */
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007BFF; /* Màu nền nút */
            color: white; /* Màu chữ nút */
            border: none;
            border-radius: 4px;
            font-size: 16px; /* Kích thước chữ nút */
            cursor: pointer;
            transition: background-color 0.3s; /* Hiệu ứng chuyển tiếp cho màu nền */
        }
        button:hover {
            background-color: #0056b3; /* Đổi màu nền khi rê chuột lên nút */
        }
        .error-message {
            color: red; /* Màu chữ thông báo lỗi */
            margin-top: 10px; /* Khoảng cách trên thông báo lỗi */
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Đăng Nhập</h2>
    <form action="/login" method="post">
        <div>
            <label for="username">Tên đăng nhập:</label>
            <input type="text" name="username" id="username" required>
        </div>
        <div>
            <label for="password">Mật khẩu:</label>
            <input type="password" name="password" id="password" required>
        </div>
        <button type="submit">Đăng Nhập</button>
    </form>
    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>
</div>
</body>
</html>
