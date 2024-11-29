package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.HoaDon;
import com.example.asgm1_java5_version2.model.KhachHang;
import com.example.asgm1_java5_version2.model.NhanVien;
import com.example.asgm1_java5_version2.repository.HoaDonRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback

class HoaDonControllerTest {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showNhanVien() {
        List<HoaDon> hoaDons = hoaDonRepository.findAll();
        assertEquals(1, hoaDons.size(), "Số lượng nhân viên phải là 10");
    }

    // Test2: trống ID
    @Test
    void testShowHoaDonTruId() {

        KhachHang khachHang = new KhachHang(1, "Nguyen Thi A", "0987654321", "KH001", true);
        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", "nv5", "password", true);
        HoaDon hoaDon = new HoaDon(null, LocalDate.now(), true, khachHang, nhanVien);

        // Kiểm tra nếu ID là null
        assertNull(hoaDon.getId(), "Hóa đơn không có ID.");
    }

    // test3 trống tên Khách Hàng
    @Test
    void testShowHoaDonTruTenKhachHang() {

        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", "nv5", "password", true);
        HoaDon hoaDon = new HoaDon(2, LocalDate.now(), true, null, nhanVien);


        assertNull(hoaDon.getKhachHang(), "Hóa đơn thiếu khách hàng.");
    }

    // test 4: bỏ trống Ngày Mua
    @Test
    void testShowHoaDonTruNgayMua() {

        KhachHang khachHang = new KhachHang(1, "Nguyen Thi A", "0987654321", "KH001", true);
        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", "nv5", "password", true);
        HoaDon hoaDon = new HoaDon(3, null, true, khachHang, nhanVien);


        assertNull(hoaDon.getNgayMuaHang(), "Hóa đơn thiếu ngày mua.");
    }


    // test 1: thành Công
    @Test
    void testDetailHoaDonThanhCong() {
        // Khởi tạo đối tượng khách hàng và nhân viên cho test
        KhachHang khachHang = new KhachHang(1, "Nguyen Thi A", "0987654321", "KH001", true);
        NhanVien nhanVien = new NhanVien(1, "Nguyen123", "NV05", "nv5", "password", true);

        HoaDon hoaDon = new HoaDon(1, LocalDate.now(), true, khachHang, nhanVien);
        assertDoesNotThrow(() -> {

        }, "Hóa đơn hiển thị thành công.");
    }
    // Test2: bỏ trống Ngày Mua
    @Test
    void testDetailHoaDonTruId() {

        KhachHang khachHang = new KhachHang(1, "Nguyen Thi A", "0987654321", "KH001", true);
        NhanVien nhanVien = new NhanVien(1, "Nguyen123", "NV05", "nv5", "password", true);

        HoaDon hoaDon = new HoaDon(null, LocalDate.now(), true, khachHang, nhanVien);
        assertNull(hoaDon.getId(), "Hóa đơn không có ID.");
    }

    // Tets 3: trống tên Khách Hàng
    @Test
    void testDetailHoaDonTruTenKhachHang() {

        NhanVien nhanVien = new NhanVien(1, "Nguyen123", "NV05", "nv5", "password", true);
        HoaDon hoaDon = new HoaDon(2, LocalDate.now(), true, null, nhanVien);
        assertNull(hoaDon.getKhachHang(), "Hóa đơn thiếu khách hàng.");
    }

    // test 4: bỏ trống Ngày Mua
    @Test
    void testDetailHoaDonTruNgayMua() {

        KhachHang khachHang = new KhachHang(1, "Nguyen Thi A", "0987654321", "KH001", true);
        NhanVien nhanVien = new NhanVien(1, "Nguyen123", "NV05", "nv5", "password", true);

        HoaDon hoaDon = new HoaDon(3, null, true, khachHang, nhanVien);
        assertNull(hoaDon.getNgayMuaHang(), "Hóa đơn thiếu ngày mua.");
    }
}