package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.MauSac;
import com.example.asgm1_java5_version2.repository.MauSacRepository;
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
@RequestMapping("/mausac")
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepository;

    @GetMapping("/show")
    public String showMauSac(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);    // Hiển thị 5 màu sắc mỗi trang
        Page<MauSac> mauSacPage = mauSacRepository.findAll(pageable);

        model.addAttribute("list_MauSac", mauSacPage.getContent());
        model.addAttribute("currentPage", mauSacPage.getNumber());
        model.addAttribute("totalPages", mauSacPage.getTotalPages());

        return "mausac/show";
    }


    @GetMapping("/search")
    public String searchByMa(@RequestParam("ma") String ma, Model model) {
        ArrayList<MauSac> searchResults = mauSacRepository.getMauSacByMa(ma);
        model.addAttribute("list_MauSac", searchResults);
        return "mausac/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteMauSac(@PathVariable("id") Integer id) {
        mauSacRepository.deleteById(id);
        return "redirect:/mausac/show";
    }

    // Hiển thị form thêm màu sắc
    @GetMapping("/add")
    public String showFormAdd(@ModelAttribute("mauSac") MauSac mauSac, Model model){
        model.addAttribute("mauSac", mauSac);
        return "/mausac/viewAdd";
    }

    @PostMapping("/add")
    public String addMauSac(@Valid @ModelAttribute("mauSac") MauSac mauSac, BindingResult bindingResult, Model model) {

        // Kiểm tra lỗi khi validate dữ liệu
        if (bindingResult.hasErrors()) {
            model.addAttribute("mauSac", mauSac);
            return "/mausac/viewAdd";
        }

        // Kiểm tra ID trùng trong cơ sở dữ liệu
        for (MauSac existingMauSac : mauSacRepository.findAll()) {
            if (existingMauSac.getId() == mauSac.getId()) {
                model.addAttribute("message", "Đã trùng ID với màu sắc trong CSDL");
                model.addAttribute("mauSac", mauSac);
                return "/mausac/viewAdd"; // Trả về form nếu có lỗi trùng ID
            }
        }

        // Nếu không có lỗi, thêm màu sắc mới
        mauSacRepository.save(mauSac);
        return "redirect:/mausac/show";
    }


    @GetMapping("/detail")
    public String detailMauSac(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("mauSac", mauSacRepository.getReferenceById(id));
        return "/mausac/detail";
    }


    @PostMapping("/update")
    public String updateMauSac(MauSac mauSac) {
        mauSacRepository.save(mauSac);
        return "redirect:/mausac/show";
    }
}
