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
@Table(name = "NhanVien")
@Builder

public class NhanVien {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng điền thông tin tên nhân viên")
    private String ten;

    @Column(name = "maNV")
    @NotBlank(message = "Vui lòng điền thông tin mã nhân viên: NV...")
    private String maNV;

    @Column(name = "tenDangNhap")
    @NotBlank(message = "Vui lòng điền thông tin tên đăng nhập của nhân viên")
    private String tenDangNhap;

    @Column(name = "matKhau")
    @NotBlank(message = "Vui lòng điền thông tin mật khẩu của nhân viên")
    private String matKhau;

    @Column(name = "trangThai")
    private boolean trangThai;

//    @Column(name = "chucVu")
//    private boolean chucVu;

}
