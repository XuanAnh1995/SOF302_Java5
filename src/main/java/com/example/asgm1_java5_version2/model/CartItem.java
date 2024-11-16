package com.example.asgm1_java5_version2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartItem {

    private Integer sanPhamChiTietId;

    private String tenSanPham;

    private String mauSac;

    private String kichThuoc;

    private Integer soLuong;

    private Double donGia;

}
