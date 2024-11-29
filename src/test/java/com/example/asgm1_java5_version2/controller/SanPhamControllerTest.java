package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.SanPham;
import com.example.asgm1_java5_version2.repository.SanPhamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.*;

@SpringBootTest
@Transactional
@Rollback

public class SanPhamControllerTest {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamController sanPhamController;

    @BeforeMethod
    public void setUp() {
        sanPhamRepository.save(new SanPham(null, "SP001", "Sbeaer Noo", true));
        sanPhamRepository.save(new SanPham(null, "SP002", "Nooii Boo", false));
    }

    @AfterMethod
    public void tearDown() {
        sanPhamRepository.deleteAll();
    }

    //Test thêm sản phẩm Các trường dữ liệu hợp lệ
    @ParameterizedTest
    @CsvFileSource(resources = "/dataAddSanPhamSuccess.csv")  // numLinesToSkip = 1 để bỏ qua dòng tiêu đề
    public void testAddSanPham(String ma, String ten, boolean trangThai) {
        // Tạo đối tượng SanPham mới với dữ liệu từ file CSV
        SanPham newSanPham = new SanPham(null, ma, ten, trangThai);

        // Lưu sản phẩm vào CSDL
        sanPhamRepository.save(newSanPham);

        // Kiểm tra đã lưu đúng chưa
        SanPham result = sanPhamRepository.findById(newSanPham.getId()).orElse(null);
        assertEquals(ma, result.getMa());
        assertEquals(ten, result.getTen());
        assertEquals(trangThai, result.isTrangThai());

        // Kiểm tra tổng số lượng sản phẩm phải là 10
        assertEquals(11, sanPhamRepository.count());
    }

    // Tên sản phẩm để trống
    @org.junit.jupiter.api.Test
    public void testAddSanPham2() {
        SanPham newSanPham = new SanPham(null, "SP11", "", true);
        try {
            sanPhamRepository.save(newSanPham);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Vui lòng điền thông tin tên sản phẩm"));
        }
    }

    // Mã sản phẩm để trống
    @org.junit.jupiter.api.Test
    public void testAddSanPham3() {
        SanPham newSanPham = new SanPham(null, "", "Nolia Adas", true);
        try {
            sanPhamRepository.save(newSanPham);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Vui lòng điền thông tin mã sản phẩm"));
        }
    }

    // Tên sản phẩm vượt quá độ dài tối đa
    @org.junit.jupiter.api.Test
    public void testAddSanPham4() {
        String longName = "Nokliaa".repeat(50);
        SanPham newSanPham = new SanPham(null, "SP11", longName, true);
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamRepository.save(newSanPham);
        });

        assertTrue(exception.getMessage().contains("Tên sản phẩm không được vượt quá 255 ký tự"));
    }

    // Mã sản phẩm vượt quá độ dài tối đa
    @org.junit.jupiter.api.Test
    public void testAddSanPham5() {
        String longMa = "Nokliaa".repeat(50);
        SanPham newSanPham = new SanPham(null, longMa, "Hum Hy", true);
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamRepository.save(newSanPham);
        });

        assertTrue(exception.getMessage().contains("Mã sản phẩm không được vượt quá 255 ký tự"));
    }

    // Test sửa thông tin sản phẩm
    // Các trường dữ liệu hợp lệ
    @Test
    public void testUpdateSanPham1() {
        sanPhamRepository.save(new SanPham(null, "SP001", "Sbeaer Noo", true));
        sanPhamRepository.save(new SanPham(null, "SP002", "Nooii Boo", false));

        // Lấy sản phẩm cũ từ cơ sở dữ liệu
        SanPham exitSanPham = sanPhamRepository.getSanPhamByMa("SP001").get(0);

        // Cập nhật tên sản phẩm
        exitSanPham.setTen("Seaer Noo1");

        // Lưu lại sản phẩm đã được sửa
        sanPhamRepository.save(exitSanPham);

        // Lấy lại sản phẩm từ cơ sở dữ liệu để kiểm tra
        SanPham result = sanPhamRepository.findById(exitSanPham.getId()).orElse(null);

        // Kiểm tra thông tin tên sản phẩm đã được cập nhật
        assertEquals("Seaer Noo1", result.getTen());
    }

    // Mã bỏ trống
    @Test
    public void testUpdateSanPham2() {
        sanPhamRepository.save(new SanPham(null, "SP001", "Sbeaer Noo", true));
        sanPhamRepository.save(new SanPham(null, "SP002", "Nooii Boo", false));

        // Lấy sản phẩm cũ từ cơ sở dữ liệu
        SanPham exitSanPham = sanPhamRepository.getSanPhamByMa("SP001").get(0);

        // Cập nhật tên sản phẩm
        exitSanPham.setMa("");

        // Lưu lại sản phẩm đã được sửa
        sanPhamRepository.save(exitSanPham);

        // Lấy lại sản phẩm từ cơ sở dữ liệu để kiểm tra
        SanPham result = sanPhamRepository.findById(exitSanPham.getId()).orElse(null);

        // Kiểm tra thông tin tên sản phẩm đã được cập nhật
        assertEquals("", result.getMa());
        assertEquals("Sbeaer Noo", result.getTen());
    }

    // Tên bỏ trống
    @Test
    public void testUpdateSanPham3() {
        sanPhamRepository.save(new SanPham(null, "SP001", "Sbeaer Noo", true));
        sanPhamRepository.save(new SanPham(null, "SP002", "Nooii Boo", false));

        // Lấy sản phẩm cũ từ cơ sở dữ liệu
        SanPham exitSanPham = sanPhamRepository.getSanPhamByMa("SP001").get(0);

        // Cập nhật tên sản phẩm
        exitSanPham.setTen("");

        // Lưu lại sản phẩm đã được sửa
        sanPhamRepository.save(exitSanPham);

        // Lấy lại sản phẩm từ cơ sở dữ liệu để kiểm tra
        SanPham result = sanPhamRepository.findById(exitSanPham.getId()).orElse(null);

        // Kiểm tra thông tin tên sản phẩm đã được cập nhật
        assertEquals("SP001", result.getMa());
        assertEquals("", result.getTen());
    }

    
}