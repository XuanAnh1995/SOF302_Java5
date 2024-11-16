package com.example.asgm1_java5_version2.controller;


import com.example.asgm1_java5_version2.model.KichThuoc;
import com.example.asgm1_java5_version2.repository.KichThuocRepository;
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
@RequestMapping("/kichthuoc")
public class KichThuocController {

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @GetMapping("/show")
    public String showKichThuoc(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);    // Hiển thị 5 kích thước mỗi trang
        Page<KichThuoc> kichThuocPage = kichThuocRepository.findAll(pageable);

        model.addAttribute("list_KichThuoc", kichThuocPage.getContent());
        model.addAttribute("currentPage", kichThuocPage.getNumber());
        model.addAttribute("totalPages", kichThuocPage.getTotalPages());

        return "kichthuoc/show";
    }

    // Tìm kiếm kích thước theo mã
    @GetMapping("/search")
    public String searchByMa(@RequestParam("ma") String ma, Model model) {
        ArrayList<KichThuoc> searchResults = kichThuocRepository.getKichThuocByMa(ma);
        model.addAttribute("list_KichThuoc", searchResults);
        return "kichthuoc/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteKichThuoc(@PathVariable("id") Integer id) {
        kichThuocRepository.deleteById(id);
        return "redirect:/kichthuoc/show";
    }

    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("kichThuoc") KichThuoc kichThuoc, Model model){
        model.addAttribute("kichThuoc", kichThuoc);
        return "/kichthuoc/viewAdd";
    }

    @PostMapping("/add")
    public String addKichThuoc(@Valid @ModelAttribute("kichThuoc") KichThuoc kichThuoc, BindingResult bindingResult,Model model) {
        // Kiểm tra lỗi khi Validate dữ liệu
        if (bindingResult.hasErrors()){
            model.addAttribute("kichThuoc", kichThuoc);
            return "/kichthuoc/viewAdd";
        }

        // Kiểm tra ID có trùng với CSDL không
        for (KichThuoc kichThuoc1 : kichThuocRepository.findAll()){
            if (kichThuoc1.getId() == kichThuoc.getId()){
                model.addAttribute("message", "Đã trùng ID với kích thước có trong CSDL");
                model.addAttribute("kichThuoc", kichThuoc);
                return "/kichthuoc/viewAdd";
            }
        }

        // Nếu không có lỗi, thêm kích thước
        kichThuocRepository.save(kichThuoc);
        return "redirect:/kichthuoc/show";
    }

    @GetMapping("/detail")
    public String detailKichThuoc(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("kichThuoc", kichThuocRepository.getReferenceById(id));
        return "kichthuoc/detail";
    }

    @PostMapping("/update")
    public String updateKichThuoc(KichThuoc kichThuoc) {
        kichThuocRepository.save(kichThuoc);
        return "redirect:/kichthuoc/show";
    }
}
