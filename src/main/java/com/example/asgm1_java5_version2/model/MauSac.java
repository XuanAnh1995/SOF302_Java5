package com.example.asgm1_java5_version2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MauSac")
@Builder

public class MauSac {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    @NotBlank(message = "Vui lòng điền thông tin mã màu sắc bắt đầu bằng ký tự MS")
    @Size(min = 3, max = 10, message = "Mã màu sắc phải có độ dài từ 3 đến 10 ký tự")
    private String ma;

    @Column(name = "ten")
    @NotNull(message = "Vui lòng điền thông tin tên màu")
    @Size(min = 2, message = "Tên màu sắc phải có ít nhất 2 ký tự")
    private String ten;

    @Column(name = "trangThai")
    private boolean trangThai;

}
