package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.SanPhamChiTiet;
import com.example.asgm1_java5_version2.repository.KichThuocRepository;
import com.example.asgm1_java5_version2.repository.MauSacRepository;
import com.example.asgm1_java5_version2.repository.SanPhamChiTietRepository;
import com.example.asgm1_java5_version2.repository.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sanphamchitiet")
public class SanPhamChiTietController {

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("/show")
    public String showSanPhamChiTiet(Model model) {
        model.addAttribute("list_SanPhamChiTiet", sanPhamChiTietRepository.findAll());
        return "sanphamchitiet/show";
    }

    @GetMapping("/search")
    public String searchSPCT(@RequestParam("maSPCT") String maSPCT, Model model){
        List<SanPhamChiTiet> resultSPCT = sanPhamChiTietRepository.getList_SanPhamChiTietByMaSPCT(maSPCT);
        model.addAttribute("list_SanPhamChiTiet", resultSPCT);
        return "sanphamchitiet/show";
    }

    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet, Model model){
        model.addAttribute("list_MauSac", mauSacRepository.findAll());
        model.addAttribute("list_KichThuoc", kichThuocRepository.findAll());
        model.addAttribute("list_SanPham", sanPhamRepository.findAll());
        model.addAttribute("sanPhamChiTiet", sanPhamChiTiet);
        return "sanphamchitiet/viewAdd";
    }

    @PostMapping("/add")
    public String addSPCT(@Valid @ModelAttribute("sanPhamChiTiet") SanPhamChiTiet sanPhamChiTiet, BindingResult bindingResult, Model model){
        // Kiểm tra lỗi Validate
        if (bindingResult.hasErrors()){
            model.addAttribute("sanPhamChiTiet", sanPhamChiTiet);
            return "sanphamchitiet/viewAdd";
        }

        // Check trùng ID
        for (SanPhamChiTiet sanPhamChiTiet1: sanPhamChiTietRepository.findAll()){
            if (sanPhamChiTiet1.getId() == sanPhamChiTiet.getId()){
                model.addAttribute("message", "Lỗi trùng ID với sản phẩm chi tiết trong CSDL");
                model.addAttribute("sanPhamChiTiet", sanPhamChiTiet);
                return "sanphamchitiet/viewAdd";
            }
        }

        // Nếu ko có lỗi, thực hiện thêm sản phẩm chi tiết
        sanPhamChiTietRepository.save(sanPhamChiTiet);

        return "redirect:/sanphamchitiet/show";
    }

    @GetMapping("/detail")
    public String detailSanPhamChiTiet(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("sanPhamChiTiet", sanPhamChiTietRepository.getReferenceById(id));
        model.addAttribute("list_SanPhamChiTiet", sanPhamChiTietRepository.findAll());
        return "sanphamchitiet/detail";
    }

}
