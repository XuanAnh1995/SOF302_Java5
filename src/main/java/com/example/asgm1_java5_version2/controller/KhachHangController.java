package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.KhachHang;
import com.example.asgm1_java5_version2.model.NhanVien;
import com.example.asgm1_java5_version2.repository.KhachHangRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping("/show")
    public String showKhachHang(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> khachHangPage = khachHangRepository.findAll(pageable);

        model.addAttribute("list_KhachHang", khachHangPage.getContent());
        model.addAttribute("currentPage", khachHangPage.getNumber());
        model.addAttribute("totalPages", khachHangPage.getTotalPages());

        return "khachhang/show";
    }

    @GetMapping("/search")
    public String searchKhachHangByMaKH(@RequestParam("maKH") String maKH, Model model){
        ArrayList<KhachHang> resultKhachHang = khachHangRepository.getKhachHangByMa(maKH);
        model.addAttribute("list_KhachHang", resultKhachHang);
        return "khachhang/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhachHang(@PathVariable("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khachhang/show";
    }

    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("khachHang") KhachHang khachHang, Model model){
        model.addAttribute("khachHang", khachHang);
        return "/khachhang/viewAdd";
    }

    @PostMapping("/add")
    public String addKhachHang(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult bindingResult, Model model) {
        // Kiểm tra lỗi Validate
        if (bindingResult.hasErrors()){
            model.addAttribute("khachHang", khachHang);
            return "/khachhang/viewAdd";
        }

        // Check trùng ID
        for (KhachHang khachHang1: khachHangRepository.findAll()) {
            if (khachHang1.getId() == khachHang.getId()){
                model.addAttribute("message", "Trùng ID khách hàng trong CSDL");
                model.addAttribute("khachHang", khachHang);
                return "/khachhang/viewAdd";
            }
        }

        // Nếu ko có lỗi thêm khách hàng
        khachHangRepository.save(khachHang);
        return "redirect:/khachhang/show";
    }

    @GetMapping("/detail")
    public String detailKhachHang(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("khachHang", khachHangRepository.getReferenceById(id));
        return "khachhang/detail";
    }

    @PostMapping("/update")
    public String updateKhachHang(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
        return "redirect:/khachhang/show";
    }
}
