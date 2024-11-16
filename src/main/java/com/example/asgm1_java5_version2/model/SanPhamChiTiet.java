package com.example.asgm1_java5_version2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
@Builder

public class SanPhamChiTiet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "maSPCT")
    @NotBlank(message = "Vui lòng điền thông tin maSPCT với định dạng: SPCT...")
    private String maSPCT;

    @ManyToOne
    @JoinColumn(name = "idMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idKichThuoc", referencedColumnName = "id")
    private KichThuoc kichThuoc;

    @ManyToOne
    @JoinColumn(name = "idSanPham", referencedColumnName = "id")
    private SanPham sanPham;

    @Column(name = "soLuong")
    @NotNull(message = "Vui lòng điền số lượng của SPCT")
    private Integer soLuong;

    @Column(name = "donGia")
    @NotNull(message = "Vui lòng điền đơn giá của SPCT")
    private Double donGia;

    @Column(name = "trangThai")
    private boolean trangThai;

}
