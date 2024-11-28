package com.example.asgm1_java5_version2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
@Builder

public class KhachHang {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng điền tên khách hàng")
    @Size(max = 50, message = "Tên khách hàng không được vượt quá 50 ký tự")
    private String ten;

    @Column(name = "sdt")
    @NotBlank(message = "Vui lòng điền số điện thoại")
    @Pattern(regexp = "^\\d{10,11}$", message = "Số điện thoại không hợp lệ")
    @NotBlank(message = "Vui lòng điền sdt khách hàng")
    private String sdt;

    @Column(name = "maKH")
    @NotBlank(message = "Vui lòng điền mã khách hàng: KH...")
    private String maKH;

    @Column(name = "trangThai")
    private boolean trangThai;

}
