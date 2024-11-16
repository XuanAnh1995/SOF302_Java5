package com.example.asgm1_java5_version2.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
@Builder

public class HoaDon {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngayMuaHang")
    private LocalDate ngayMuaHang;

    @Column(name = "trangThai")
    private boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "idKhachHang", referencedColumnName = "id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idNhanVien", referencedColumnName = "id")
    private NhanVien nhanVien;

}
