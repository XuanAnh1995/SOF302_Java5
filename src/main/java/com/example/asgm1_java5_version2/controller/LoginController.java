package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.NhanVien;
import com.example.asgm1_java5_version2.repository.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
@Autowired
    NhanVienRepository repoNV;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
// kiem tra usernam va passsword
        if(username.isEmpty()){
            model.addAttribute("errorMessage", "Khong de trong ten dang nhap");
            return "login";  // Quay lại trang login với thông báo lỗi
        } if(password.isEmpty()){
            model.addAttribute("errorMessage", "Khong de trong mat khau");
            return "login";
        }

        List<NhanVien> list = repoNV.findAll();
        Optional<NhanVien> first = list.stream()
                .filter(n -> n.getTenDangNhap().equals(username) && n.getMatKhau().equals(password))
                .findFirst();



        if (first.isPresent()) {
            session.setAttribute("user", first.get());  // Lưu thông tin người dùng vào session
            return "redirect:/main";  // Chuyển hướng đến trang dashboard hoặc trang chủ
        } else {

            model.addAttribute("errorMessage", "Invalid username or password");
            return "login";  // Quay lại trang login với thông báo lỗi
        }



    }

}
