package com.example.asgm1_java5_version2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

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
        if ("admin".equals(username) && "123".equals(password)){
            session.setAttribute("loggedInUser", username);
            return "main";
        } else {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }
    }

}
