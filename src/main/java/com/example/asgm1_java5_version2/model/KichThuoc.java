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
@Table(name = "KichThuoc")
@Builder

public class KichThuoc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    @NotBlank(message = "Vui lòng điền thông tin mã kích thươc: KT...")
    private String ma;

    @Column(name = "ten")
    @NotBlank(message = "Vui lòng điền thông tin tên kích thước: size")
    private String ten;

    @Column(name = "trangThai")
    private boolean trangThai;

}
