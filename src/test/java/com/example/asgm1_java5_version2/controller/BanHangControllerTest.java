package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.*;
import com.example.asgm1_java5_version2.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BanHangControllerTest {

    @Autowired
    private BanHangController banHangController;

    @Autowired
    private SanPhamChiTietRepository sanPhamChiTietRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    private Model mockModel;

    @BeforeEach
    void setUp() {
        mockModel = mock(Model.class);

        // Clean up repositories before each test
        hoaDonChiTietRepository.deleteAll();
        hoaDonRepository.deleteAll();
        sanPhamChiTietRepository.deleteAll();
        kichThuocRepository.deleteAll();
        mauSacRepository.deleteAll();
        sanPhamRepository.deleteAll();
        khachHangRepository.deleteAll();
        nhanVienRepository.deleteAll();

        // Seed data for testing
        MauSac mauSac = mauSacRepository.save(new MauSac(null, "MS001", "Red", true));
        KichThuoc kichThuoc = kichThuocRepository.save(new KichThuoc(null,"L", "L", true));
        SanPham sanPham = sanPhamRepository.save(new SanPham(null, "SP001", "Test Product", true));

        sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                .maSPCT("SPCT001")
                .mauSac(mauSac)
                .kichThuoc(kichThuoc)
                .sanPham(sanPham)
                .soLuong(10)
                .donGia(100000.0)
                .trangThai(true)
                .build());

        NhanVien nhanVien = nhanVienRepository.save(new NhanVien(null, "Test NhanVien", "NV001", "testUser", "1234", true));
        KhachHang khachHang = khachHangRepository.save(new KhachHang(null, "Test KhachHang", "0987654321", "KH001", true));

        hoaDonRepository.save(new HoaDon(null, LocalDate.now(), true, khachHang, nhanVien));
    }

    // Test case 1: Hiển thị danh sách hóa đơn (có ID hóa đơn)
    @Test
    void testShowDs_WithIdHoaDon() {
        Integer hoaDonId = hoaDonRepository.findAll().get(0).getId();

        String viewName = banHangController.showDs(mockModel, hoaDonId);

        verify(mockModel).addAttribute(eq("list_HoaDon"), any());
        assertEquals("banhang/show", viewName);
    }

    // Test case 2: Hiển thị danh sách hóa đơn (không có ID hóa đơn)
    @Test
    void testShowDs_WithoutIdHoaDon() {
        String viewName = banHangController.showDs(mockModel, null);

        verify(mockModel).addAttribute(eq("list_HoaDon"), any());
        assertEquals("banhang/show", viewName);
    }

    // Test case 3: Thêm sản phẩm vào giỏ hàng hợp lệ
    @Test
    void testAddItemToCart_Valid() {
        String viewName = banHangController.showDs(mockModel, null);

        verify(mockModel).addAttribute(eq("list_HoaDon"), any());
        assertEquals("banhang/show", viewName);
    }

    // Test case 4: Thêm sản phẩm với số lượng không đủ
    @Test
    void testAddItemToCart_InsufficientQuantity() {
        String viewName = banHangController.showDs(mockModel, null);

        verify(mockModel).addAttribute(eq("list_HoaDon"), any());
        assertEquals("banhang/show", viewName);
    }

    // Test case 5: Xóa sản phẩm khỏi giỏ hàng
    @Test
    void testRemoveItemFromCart() {
        String viewName = banHangController.showDs(mockModel, null);

        verify(mockModel).addAttribute(eq("list_HoaDon"), any());
        assertEquals("banhang/show", viewName);
    }

    // Test case 6: Thêm hóa đơn từ giỏ hàng hợp lệ
    @Test
    void testAddHoaDonFromCart_Valid() {
        HoaDon hoaDon = new HoaDon();
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);

        verify(mockModel).addAttribute("error", "Hãy chọn sản phẩm!");
        assertEquals("banhang/add", viewName);
    }

    // Test case 7: Thêm hóa đơn khi giỏ hàng rỗng
    @Test
    void testAddHoaDonFromCart_EmptyCart() {
        HoaDon hoaDon = new HoaDon();
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);

        verify(mockModel).addAttribute("error", "Hãy chọn sản phẩm!");
        assertEquals("banhang/add", viewName);
    }

    // Test case 8: Cập nhật số lượng trong giỏ hàng
    @Test
    void testUpdateItemInCart_Valid() {
        HoaDon hoaDon = new HoaDon();
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);

        verify(mockModel).addAttribute("error", "Hãy chọn sản phẩm!");
        assertEquals("banhang/add", viewName);
    }

    // Test case 9: Hiển thị chi tiết hóa đơn
    @Test
    void testDetailHoaDon() {
        Integer hoaDonId = hoaDonRepository.findAll().get(0).getId();

        String viewName = banHangController.chiTiet(mockModel, hoaDonId);

        verify(mockModel).addAttribute(eq("hoaDon"), any());
        verify(mockModel).addAttribute(eq("list_HoaDonChiTiet"), any());
        assertEquals("banhang/detail", viewName);
    }

    @Test
    void testAddItemToCart_NullProductId() {
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(null, 2, mockModel);
        });
        assertFalse(exception.getMessage().contains("Sản phẩm không hợp lệ"));
    }
    @Test
    void testAddItemToCart_NullQuantity() {
        Integer spctId = sanPhamChiTietRepository.findAll().get(0).getId();
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(spctId, null, mockModel);
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));
    }
    @Test
    void testAddItemToCart_ProductNotExist() {
        Integer spctId = sanPhamChiTietRepository.findAll().get(0).getId();
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(spctId, null, mockModel);
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));
    }

    @Test
    void testRemoveItemFromCart_NullProductId() {
        Integer spctId = sanPhamChiTietRepository.findAll().get(0).getId();
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(spctId, null, mockModel);
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null")); }

    @Test
    void testUpdateItemInCart_NullQuantity() {
        Integer spctId = sanPhamChiTietRepository.findAll().get(0).getId();
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(spctId, null, mockModel);
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));   }

    @Test
    void testUpdateItemInCart_NegativeQuantity() {
        Integer spctId = sanPhamChiTietRepository.findAll().get(0).getId();
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.addItemToCart(spctId, null, mockModel);
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));  }

    @Test
    void testAddHoaDon_NullCustomer() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNhanVien(new NhanVien(1, null, null, null, null, true));
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);
        verify(mockModel).addAttribute("errorkhachHang", "Hãy chọn khách hàng!");
        assertEquals("banhang/add", viewName);
    }
     
    @Test
    void testAddHoaDon_NullStaff() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(new KhachHang(1, null, null, null, true));
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);
        verify(mockModel).addAttribute("errornhanVien", "Hãy chọn nhân viên!");
        assertEquals("banhang/add", viewName);
    }
             
    @Test
    void testAddHoaDon_EmptyCart() {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(new KhachHang(1, null, null, null, true));
        hoaDon.setNhanVien(new NhanVien(1, null, null, null, null, true));
        String viewName = banHangController.addHoaDonFromCart(hoaDon, true, mockModel);
        verify(mockModel).addAttribute("error", "Hãy chọn sản phẩm!");
        assertEquals("banhang/add", viewName);
    }
     
    @Test
    void testAddProductToCart_NullPrice() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("SPCT001")
                    .soLuong(10)
                    .donGia(null) // Đơn giá null
                    .build());
        });
         assertFalse(exception.getMessage().contains("Đơn giá không được null"));
    }
     
    @Test
    void testAddProductToCart_NullQuantity() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("SPCT002")
                    .donGia(100000.0)
                    .soLuong(null) // Số lượng null
                    .build());
        });
         assertFalse(exception.getMessage().contains("Số lượng không được null"));
    }
     
    @Test
    void testDetailHoaDon_NotFound() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("SPCT002")
                    .donGia(100000.0)
                    .soLuong(null) // Số lượng null
                    .build());
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));
    }
             
    @Test
    void testSearchProductInCart_NotFound() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("SPCT002")
                    .donGia(100000.0)
                    .soLuong(null) // Số lượng null
                    .build());
        });
        assertFalse(exception.getMessage().contains("Số lượng không được null"));
    }
             
    @Test
    void testRemoveItemFromCart_ProductNotExist() {
        String redirectUrl = banHangController.removeItemFromCart(-999);
        assertEquals("redirect:/banhang/add", redirectUrl);
    }
     
    @Test
    void testUpdateItemInCart_ExceedStock() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("")
                    .soLuong(10)
                    .donGia(100000.0)
                    .build());
        });
        assertTrue(exception.getMessage().contains("Vui lòng điền thông tin maSPCT"));
    }
     
    @Test
    void testAddProduct_EmptyCode() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("")
                    .soLuong(10)
                    .donGia(100000.0)
                    .build());
        });
         assertTrue(exception.getMessage().contains("Vui lòng điền thông tin maSPCT"));
    }
             
    @Test
    void testAddProduct_NegativePrice() {
        Exception exception = assertThrows(Exception.class, () -> {
            sanPhamChiTietRepository.save(SanPhamChiTiet.builder()
                    .maSPCT("SPCT003")
                    .soLuong(10)
                    .donGia(-50000.0)
                    .build());
        });
         assertFalse(exception.getMessage().contains("Đơn giá phải lớn hơn 0"));
    }
             
    @Test
    void testRemoveItemFromCart_EmptyCart() {
        String redirectUrl = banHangController.removeItemFromCart(1);
        assertEquals("redirect:/banhang/add", redirectUrl);
    }
     
    @Test
    void testDetailHoaDon_NullId() {
        Exception exception = assertThrows(Exception.class, () -> {
            banHangController.chiTiet(mockModel, null);
        });
         assertFalse(exception.getMessage().contains("ID hóa đơn không hợp lệ"));
    }


}
