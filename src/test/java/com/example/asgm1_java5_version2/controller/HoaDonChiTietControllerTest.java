package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.HoaDonChiTiet;
import com.example.asgm1_java5_version2.repository.HoaDonChiTietRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class HoaDonChiTietControllerTest {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonChiTietController hoaDonChiTietController;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void showHoaDonChiTiet_HopLe() {
      List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietRepository.findAll();
      assertEquals(22, hoaDonChiTiets.size(), "số lượng hóa đơn chi tiết phải là 20");
    }

    // lỗi phân trang
    @Test
    void showHoaDonChiTiet_PhanTrang(){
        Page<HoaDonChiTiet> page = hoaDonChiTietRepository.findAll(PageRequest.of(0, 5));
        assertEquals(5, page.getContent().size(), "Lỗi phân trang");
        assertTrue(page.hasNext(), "Không có trang tiếp theo");

    }

    // hiển thị  sai trạng thái
    @Test
    void showHoaDonChiTiet_TrangThai() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 2, 2.0, false, 1,2 );
        assertEquals(hoaDonChiTiet.isTrangThai(), false);
    }

    // hiển thị sai trường id sản phẩm chi tiết
    @Test
    void showHoaDonChiTiet_SaiSanPhamChiTiet() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 2, 2.0, true, 0,2 );
        assertEquals(null, hoaDonChiTiet.getSanPhamChiTiet());
    }

    // hiển thị sai trường số lượng
    @Test
    void showlHoaDonChiTiet_SaiSoLuong() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 2.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getSoLuong());
    }

    // hiển thị sai trường đơn giá
    @Test
    void showlHoaDonChiTiet_SaiDonGia() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 0.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getDonGia());
    }

    // hiển thị sai trường id
    @Test
    void showHoaDonChiTiet_SaiID() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(0, 0, 2.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getDonGia());
    }

    // hiển thị sai trường id hóa đơn
    @Test
    void showlHoaDonChiTiet_SaiIDHoaDon() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 2.0, true, 1,0);
        assertEquals(null, hoaDonChiTiet.getSanPhamChiTiet());
    }


    //detail
    // chi tiết hdct  sai trạng thái
    @Test
    void detailHoaDonChiTiet_TrangThai() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 2, 2.0, false, 1,2 );
        assertEquals(false, hoaDonChiTiet.isTrangThai());
    }

    // chi tiết hdct  sai id sản phẩm chi tiết
    @Test
    void detailHoaDonChiTiet_SaiSanPhamChiTiet() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 2, 2.0, true, 0,2 );
        assertEquals(hoaDonChiTiet.getSanPhamChiTiet(), null);
    }

    // chi tiết hdct sai số lượng
    @Test
    void detaillHoaDonChiTiet_SaiSoLuong() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 2.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getSoLuong());
    }

    // chi tiết hdct sai đơn giá
    @Test
    void detaillHoaDonChiTiet_SaiDonGia() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 0.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getDonGia());
    }

    // chi tiết hdct sai id
    @Test
    void detailHoaDonChiTiet_SaiID() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(0, 0, 2.0, true, 1,2 );
        assertEquals(null, hoaDonChiTiet.getId());
    }

    // chi tiết hdct sai id hóa đơn
    @Test
    void detaillHoaDonChiTiet_SaiIDHoaDon() {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(1, 0, 2.0, true, 1,0);
        assertEquals(null, hoaDonChiTiet.getSanPhamChiTiet());
    }


}