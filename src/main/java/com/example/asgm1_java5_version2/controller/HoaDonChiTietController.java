package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.HoaDonChiTiet;
import com.example.asgm1_java5_version2.repository.HoaDonChiTietRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hoadonchitiet")
public class HoaDonChiTietController {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @GetMapping("/show")
    public String showHoaDonChiTiet(HttpSession session, Model model) {
        model.addAttribute("list_HoaDonChiTiet", hoaDonChiTietRepository.findAll());
        return "hoadonchitiet/show";
    }

    @GetMapping("/detail")
    public String detailHoaDonChiTiet(HttpSession session, @RequestParam("id") Integer id, Model model) {
        model.addAttribute("hoaDonChiTiet", hoaDonChiTietRepository.getReferenceById(id));
        model.addAttribute("list_HoaDonChiTiet", hoaDonChiTietRepository.findAll());
        return "hoadonchitiet/show";
    }

}
