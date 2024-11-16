package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.MauSac;
import com.example.asgm1_java5_version2.model.NhanVien;
import com.example.asgm1_java5_version2.repository.NhanVienRepository;
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
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @GetMapping("/show")
    public String showNhanVien(@RequestParam(defaultValue = "0") int page,Model model) {
        Pageable pageable = PageRequest.of(page, 5);    // Hiển thị 5 nhân viên mối trang
        Page<NhanVien> nhanVienPage = nhanVienRepository.findAll(pageable);

        model.addAttribute("list_NhanVien", nhanVienPage.getContent());
        model.addAttribute("currentPage", nhanVienPage.getNumber());
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());

        return "nhanvien/show";
    }

    @GetMapping("/search")
    public String searchNhanVienByMaNV(@RequestParam("maNV") String maNV, Model model){
        ArrayList<NhanVien> resultNhanVien = nhanVienRepository.getNhanVienByMaNV(maNV);
        model.addAttribute("list_NhanVien", resultNhanVien);
        return "/nhanvien/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") Integer id) {
        nhanVienRepository.deleteById(id);
        return "redirect:/nhanvien/show";
    }

    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("nhanVien") NhanVien nhanVien, Model model){
        model.addAttribute("nhanVien", nhanVien);
        return "/nhanvien/viewAdd";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult bindingResult, Model model) {
        // Kiểm tra lỗi khi Validate dữ liệu
        if (bindingResult.hasErrors()){
            model.addAttribute("nhanVien", nhanVien);
            return "/nhanvien/viewAdd";
        }

        // Check ID trùng trong CSDL
        for (NhanVien nhanVien1 : nhanVienRepository.findAll()){
            if (nhanVien.getId() == nhanVien1.getId()){
                model.addAttribute("message", "Đã trùng với ID nhân viên trong CSDL");
                model.addAttribute("nhanVien", nhanVien);
                return "/nhanvien/viewAdd";
            }
        }

        // Nếu không lỗi, thực hiện thêm nhân viên
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhanvien/show";
    }

    @GetMapping("/detail")
    public String detailNhanVien(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("nhanVien", nhanVienRepository.getReferenceById(id));
        return "nhanvien/detail";
    }

    @PostMapping("/update")
    public String updateNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "redirect:/nhanvien/show";
    }
}
