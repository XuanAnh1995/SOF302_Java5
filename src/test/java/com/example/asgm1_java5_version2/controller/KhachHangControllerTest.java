package com.example.asgm1_java5_version2.controller;
import com.example.asgm1_java5_version2.model.KhachHang;
import com.example.asgm1_java5_version2.repository.KhachHangRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class KhachHangControllerTest {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private KhachHangController khachHangController;

    @BeforeEach
    void setUp() {
        khachHangRepository.deleteAll();
        khachHangRepository.save(new KhachHang(null, "Nguyen Van A", "0987654321", "KH001", true));
        khachHangRepository.save(new KhachHang(null, "Nguyen Van B", "0987654322", "KH002", false));
    }

    @Test
    void testAddKhachHang() {
        KhachHang newKhachHang = new KhachHang(null, "Le Thi C", "0987654323", "KH003", true);
        khachHangRepository.save(newKhachHang);

        KhachHang result = khachHangRepository.findById(newKhachHang.getId()).orElse(null);

        assertEquals("Le Thi C", result.getTen());
        assertEquals("0987654323", result.getSdt());
    }
    // Test case 2: Tên khách hàng trống
    @Test
    void testAddKhachHang_EmptyName() {
        KhachHang newKhachHang = new KhachHang(null, "", "0123456789", "KH00", true);

        try {
            khachHangRepository.save(newKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Vui lòng điền tên khách hàng"));
        }
    }

    // Test case 3: Số điện thoại trống
    @Test
    void testAddKhachHang_EmptyPhone() {
        KhachHang newKhachHang = new KhachHang(null, "Le Van B", "", "KH003", true);

        try {
            khachHangRepository.save(newKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Vui lòng điền sdt khách hàng"));
        }
    }

    // Test case 4: Mã khách hàng trống
    @Test
    void testAddKhachHang_EmptyMaKH() {
        KhachHang newKhachHang = new KhachHang(null, "Le Van C", "0123456789", "", true);

        try {
            khachHangRepository.save(newKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Vui lòng điền mã khách hàng"));
        }
    }

    // Test case 5: Số điện thoại không hợp lệ (dưới 10 ký tự)
    @Test
    void testAddKhachHang_InvalidPhone_Short() {
        KhachHang newKhachHang = new KhachHang(null, "Le Van D", "12345678", "KH004", true);

        try {
            khachHangRepository.save(newKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Số điện thoại không hợp lệ"));
        }
    }

    // Test case 6: Tên khách hàng vượt quá độ dài tối đa
        @Test
        void testAddKhachHang_LongName() {
            String longName = "Nguyen 11".repeat(20); // Tên dài hơn 50 ký tự
            KhachHang newKhachHang = new KhachHang(null, longName, "0123456789", "KH005", true);

            Exception exception = assertThrows(Exception.class, () -> {
                khachHangRepository.save(newKhachHang);
            });

            assertTrue(exception.getMessage().contains("Tên khách hàng không được vượt quá 50 ký tự"));
        }

    // Test case 7: Mã khách hàng trùng lặp
    @Test
    void testAddKhachHang_DuplicateMaKH() {
        khachHangRepository.save(new KhachHang(null, "Le Van E", "0123456789", "KH006", true));

        KhachHang duplicateKhachHang = new KhachHang(null, "Le Van F", "0123456789", "KH006", true);

        try {
            khachHangRepository.save(duplicateKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Trùng mã khách hàng"));
        }
    }

    // Test case 8: Thêm khách hàng không có trạng thái (null)
    @Test
    void testAddKhachHang_NullTrangThai() {
        KhachHang newKhachHang = new KhachHang(null, "Le Van G", "0123456789", "KH007", false);

        khachHangRepository.save(newKhachHang);
        KhachHang result = khachHangRepository.findById(newKhachHang.getId()).orElse(null);

        assertEquals("Le Van G", result.getTen());
        assertEquals(false, result.isTrangThai());
    }

    // Test case 9: Số điện thoại trùng lặp (tùy nghiệp vụ)
    @Test
    void testAddKhachHang_DuplicatePhone() {
        khachHangRepository.save(new KhachHang(null, "Le Van H", "0123456789", "KH008", true));

        KhachHang duplicatePhoneKhachHang = new KhachHang(null, "Le Van I", "0123456789", "KH009", true);

        try {
            khachHangRepository.save(duplicatePhoneKhachHang);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Trùng số điện thoại"));
        }
    }

    // Test case 10: Thêm khách hàng hợp lệ (trường hợp khác)
    @Test
    void testAddKhachHang_AnotherValid() {
        KhachHang newKhachHang = new KhachHang(null, "Nguyen Van X", "0987654321", "KH010", false);
        khachHangRepository.save(newKhachHang);

        KhachHang result = khachHangRepository.findById(newKhachHang.getId()).orElse(null);
        assertEquals("Nguyen Van X", result.getTen());
        assertEquals("0987654321", result.getSdt());
        assertEquals("KH010", result.getMaKH());
    }

    // Test cập nhật với dữ liệu hợp lệ
    @Test
    void testUpdateKhachHang_ValidData() {
        KhachHang existingKhachHang = khachHangRepository.getKhachHangByMa("KH001").get(0);
        existingKhachHang.setTen("Updated Name");
        existingKhachHang.setSdt("0912345678");

        khachHangRepository.save(existingKhachHang);

        KhachHang result = khachHangRepository.findById(existingKhachHang.getId()).orElse(null);
        assertEquals("Updated Name", result.getTen());
        assertEquals("0912345678", result.getSdt());
    }


    // Test cập nhật mà không cho phép thay đổi ID
    @Test
    void testUpdateKhachHang_IdUnchanged() {
        KhachHang existingKhachHang = khachHangRepository.getKhachHangByMa("KH001").get(0);
        Integer originalId = existingKhachHang.getId();

        existingKhachHang.setTen("New Name");
        khachHangRepository.save(existingKhachHang);

        KhachHang result = khachHangRepository.findById(originalId).orElse(null);
        assertEquals(originalId, result.getId());
    }
    //  cap nhap khách hàng không có trạng thái (null)
    @Test
    void updateAddKhachHang_NullTrangThai() {
        KhachHang newKhachHang = new KhachHang(null, "Le Van G", "0123456789", "KH007", false);

        khachHangRepository.save(newKhachHang);
        KhachHang result = khachHangRepository.findById(newKhachHang.getId()).orElse(null);

        assertEquals("Le Van G", result.getTen());
        assertEquals(false, result.isTrangThai());
    }


    // Test cập nhật trạng thái khách hàng
    @Test
    void testUpdateKhachHang_TrangThai() {
        KhachHang existingKhachHang = khachHangRepository.getKhachHangByMa("KH001").get(0);
        existingKhachHang.setTrangThai(false);

        khachHangRepository.save(existingKhachHang);

        KhachHang result = khachHangRepository.findById(existingKhachHang.getId()).orElse(null);
        assertEquals(false, result.isTrangThai());
    }
/// tim kiem khach hang theo ma
    @Test
    void testSearchKhachHang() {
        var result = khachHangRepository.getKhachHangByMa("KH001");

        assertEquals(1, result.size());
        assertEquals("Nguyen Van A", result.get(0).getTen());
    }
    @Test
    void testSearchKhachHang2() {
        var result = khachHangRepository.getKhachHangByMa("KH002");

        assertEquals(1, result.size());
        assertEquals("Nguyen Van B", result.get(0).getTen());
    }

    @Test
    void testDeleteKhachHang() {
        KhachHang existingKhachHang = khachHangRepository.findById(1).get();
        khachHangRepository.delete(existingKhachHang);

        assertEquals(2, khachHangRepository.findAll().size());
    }


}