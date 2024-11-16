package com.example.asgm1_java5_version2.controller;


import com.example.asgm1_java5_version2.repository.HoaDonRepository;
import com.example.asgm1_java5_version2.repository.KhachHangRepository;
import com.example.asgm1_java5_version2.repository.NhanVienRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hoadon")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/show")
    public String showHoaDon(HttpSession session, Model model) {
        model.addAttribute("list_HoaDon", hoaDonRepository.findAll());
        return "hoadon/show";
    }

    @GetMapping("/detail")
    public String detailHoaDon(HttpSession session, @RequestParam("id") Integer id, Model model) {
        model.addAttribute("hoaDon", hoaDonRepository.getReferenceById(id));
        model.addAttribute("list_HoaDon", hoaDonRepository.findAll());
        return "hoadon/show";
    }

}
