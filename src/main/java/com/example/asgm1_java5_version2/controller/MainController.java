package com.example.asgm1_java5_version2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String showMain(Model model, HttpSession session){
        if (session.getAttribute("user") == null) {
            return "redirect:/login"; // Chuyển hướng về trang đăng nhập
        }
        return "main";
    }

}
