package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.SanPham;
import com.example.asgm1_java5_version2.repository.SanPhamRepository;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/sanpham")
public class SanPhamController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @GetMapping("/show")
    public String showSanPham(@RequestParam(defaultValue = "0") int page ,Model model) {
        Pageable pageable = PageRequest.of(page, 5);    // Hiển thị 5 sản phẩm mỗi trang
        Page<SanPham> sanPhamPage = sanPhamRepository.findAll(pageable);

        model.addAttribute("list_SanPham", sanPhamPage.getContent());
        model.addAttribute("currentPage", sanPhamPage.getNumber());
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "sanpham/show";
    }

    @GetMapping("/search")
    public String searchSanPhamByMa(@RequestParam("ma") String ma, Model model){
        ArrayList<SanPham> resultSanPham = sanPhamRepository.getSanPhamByMa(ma);
        model.addAttribute("list_SanPham", resultSanPham);
        return "sanpham/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") Integer id) {
        sanPhamRepository.deleteById(id);
        return "redirect:/sanpham/show";
    }

    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("sanPham") SanPham sanPham, Model model){
        model.addAttribute("sanPham", sanPham);
        return "/sanpham/viewAdd";
    }

    @PostMapping("/add")
    public String addSanPham(@Valid @ModelAttribute("sanPham") SanPham sanPham, BindingResult bindingResult, Model model) {
        // Kiểm tra lỗi khi Validate dữ liệu
        if (bindingResult.hasErrors()){
            model.addAttribute("sanPham", sanPham);
            return "/sanpham/viewAdd";
        }

        // Kiểm tra trùng ID trong CSDL
        for (SanPham sanPham1: sanPhamRepository.findAll()) {
            if (sanPham1.getId() == sanPham.getId()){
                model.addAttribute("message", "Đã trùng ID với sản phẩm trong CSDL");
                model.addAttribute("sanPham", sanPham);
                return "/sanpham/viewAdd";
            }
        }

        // Nếu không có lỗi thì thêm sản phẩm
        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/show";
    }

    @GetMapping("/detail")
    public String detailSanPham(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("sanPham", sanPhamRepository.getReferenceById(id));
        return "sanpham/detail";
    }

    @PostMapping("/update")
    public String updateSanPham(HttpSession session, SanPham sanPham) {
        sanPhamRepository.save(sanPham);
        return "redirect:/sanpham/show";
    }
}
