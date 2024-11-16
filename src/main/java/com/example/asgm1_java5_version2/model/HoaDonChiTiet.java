package com.example.asgm1_java5_version2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
@Builder


public class HoaDonChiTiet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "donGia")
    private Double donGia;

    @Column(name = "trangThai")
    private boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "idSPCT", referencedColumnName = "id")
    private SanPhamChiTiet sanPhamChiTiet;

    @ManyToOne
    @JoinColumn(name = "idHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;

}
