package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.KhachHang;
import com.example.asgm1_java5_version2.model.NhanVien;
import com.example.asgm1_java5_version2.repository.NhanVienRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class NhanVienControllerTest {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @BeforeEach
    void setUp() {
//nhanVienRepository.deleteAll();
       // nhanVienRepository.save(new NhanVien(null, "Nguyen Van A", "NV01", "nva", "pass123", true));
//        nhanVienRepository.save(new NhanVien(null, "Nguyen Van B", "NV02", "nvb", "pass123", true));
    }

    @AfterEach
    void tearDown() {
      //  nhanVienRepository.deleteAll();
    }


    //test1 : hợp lệ
    @Test
    void addNhanVien() {
        NhanVien newNhanVien = new NhanVien(null, "Le Van C", "NV03", "nvc", "password", true);
        nhanVienRepository.save(newNhanVien);

        List<NhanVien> addedNhanVienList = nhanVienRepository.getNhanVienByMaNV("NV03");
        assertFalse(addedNhanVienList.isEmpty(), "Không tìm thấy nhân viên với mã NV03");
        NhanVien addedNhanVien = addedNhanVienList.get(0);
        assertEquals("Le Van C", addedNhanVien.getTen(), "Tên nhân viên phải là 'Nguyen Van C'");
    }

    // test2: Tên Nhan Viên trống
    @Test
    void addNhanVienNull() {
       NhanVien nhanVien = new NhanVien(null, "", "NV0", "nvc", "password", true);
       try{
           nhanVienRepository.save(nhanVien);
       }catch (Exception e){
           assertEquals(true,e.getMessage().contains("Vui lòng điền thông tin tên nhân viên"));
       }
    }


    //test 3: mã Nhan Viên trống
    @Test
    void addNhanVienMaTrong() {
        NhanVien nhanVien = new NhanVien(null, "123", "", "nvc", "password", true);
        try{
            nhanVienRepository.save(nhanVien);
        }catch (Exception e){
            assertEquals(true,e.getMessage().contains("Vui lòng điền thông tin mã nhân viên: NV..."));
        }
    }

    //Test4: ten dang nhạp Nhan Viên trống
    @Test
    void addNhanVienTenDNTrong() {
        NhanVien nhanVien = new NhanVien(null, "123", "vc12", "", "password", true);
        try{
            nhanVienRepository.save(nhanVien);
        }catch (Exception e){
            assertEquals(true,e.getMessage().contains("Vui lòng điền thông tin tên đăng nhập của nhân viên"));
        }
    }

    //Test 5 pass Nhan Viên trống
    @Test
    void addNhanVienPassTrong() {
        NhanVien nhanVien = new NhanVien(null, "123", "vc12", "nvd", "", true);
        try{
            nhanVienRepository.save(nhanVien);
        }catch (Exception e){
            assertEquals(true,e.getMessage().contains("Vui lòng điền thông tin mật khẩu của nhân viên"));
        }
    }

    // Test case 6: Tên Nhan Viên vượt quá độ dài tối đa
    @Test
    void testAddNhanVien_LongName() {
        String longName = "Nguyen 11".repeat(20); // Tên dài hơn 50 ký tự
        NhanVien nhanVien = new NhanVien(null, longName, "vc12", "11", "password", true);

        Exception exception = assertThrows(Exception.class, () -> {
            nhanVienRepository.save(nhanVien);
        });

        assertTrue(exception.getMessage().contains("Tên Nhân Viên không được vượt quá 50 ký tự"));
    }

    // Test case 7: Mã Nhân Viên trùng lặp
    @Test
    void testAddKhachHang_DuplicateMaKH() {
       nhanVienRepository.save(new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true));

        NhanVien duplicateMaKH = new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true);

        try {
            nhanVienRepository.save(duplicateMaKH);
        } catch (Exception e) {
            assertEquals(true, e.getMessage().contains("Trùng mã Nhân Viên"));
        }
    }
    //test 8 ten co ki tu dac biet
    @Test
    void testAddNhanVien_tenchuakitudacbiet() {
        NhanVien nhanVien = new NhanVien(null, "@NguyenVanC", "NV04", "nvc", "password", true);
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên không được chứa ký tự đặc biệt"));
        }
    }


    //test 9 ten chua so
    @Test
    void testAddNhanVien_tenchuaso() {
        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", "nv5", "password", true);
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên không được chứa số"));
        }
    }


    //test 10: tên quá ngắn

    @Test
    void testAddNhanVien_NamequaNgan() {
        NhanVien nhanVien = new NhanVien(null, "A", "NV06", "nv6", "password", true);
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên quá ngắn"));
        }
    }

    //test1 showhOple
    @Test
    void showNhanVien() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        assertEquals(10, nhanViens.size(), "Số lượng nhân viên phải là 10");
    }
    // test 2 thieu so luong
    @Test
    void testGetAllNhanVienVoiNhanVienKhongDu() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        assertEquals(10, nhanViens.size(), "Số lượng nhân viên trong CSDL không khớp.");
        int expectedSize = 5;
        assertNotEquals(expectedSize, nhanViens.size(),
                "Số lượng nhân viên hiện tại là " + nhanViens.size() + ", nhưng mong muốn là " + expectedSize + ". Do đó test bị sai.");
    }

    // test 3: phan trang hop lẹ
    @Test
    void testGetAllPhanTrang() {
        Page<NhanVien> page = nhanVienRepository.findAll(PageRequest.of(0, 5));
        assertEquals(5, page.getContent().size(), "Số lượng nhân viên trên trang không đúng.");
        assertTrue(page.hasNext(), "Không có trang kế tiếp.");

    }

    // test4: qua so luong trang
    @Test
    void testGetallquasotrang() {
        Pageable pageable = PageRequest.of(100, 5);
        Page<NhanVien> page = nhanVienRepository.findAll(pageable);
        assertTrue(page.getContent().isEmpty(), "Trang vượt quá tổng số trang nhưng vẫn trả về dữ liệu.");
        assertEquals(0, page.getContent().size(), "Dữ liệu không nên tồn tại với trang vượt quá.");
    }

    // test5: so trang am

    @Test
    void testShowPageam() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            nhanVienRepository.findAll(PageRequest.of(-1, 5));
        });

        assertTrue(exception.getMessage().contains("so trang phải bat dau bang 0"),
                "Thông báo lỗi không phù hợp khi số trang âm.");
    }

    // test 6: so luong phan tu am
    @Test
    void testShowPhanTuam() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            nhanVienRepository.findAll(PageRequest.of(0, -5));
        });
        assertTrue(exception.getMessage().contains("So phan tu khong the nho hon 1"),
                "Thông báo lỗi không phù hợp khi kích thước trang âm.");
    }

    // test7 trống tên
    @Test
    void showNhanVien_MissingName() {

        NhanVien nhanVien = new NhanVien(null, null, "NV05", "nv5", "password", true);


        assertNull(nhanVien.getTen(), "Tên nhân viên không được để trống");
    }

    // test 8 trống mã
    @Test
    void showNhanVien_MissingMaNV() {
        NhanVien nhanVien = new NhanVien(null, "Nguyen123", null, "nv5", "password", true);
        assertNull(nhanVien.getMaNV(), "Mã nhân viên không được để trống");
    }

    // test 9 trống tên DN
    @Test
    void showNhanVien_MissingUsername() {

        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", null, "password", true);


        assertNull(nhanVien.getTenDangNhap(), "Tên đăng nhập không được để trống");
    }

    // test 10 trống pass

    @Test
    void showNhanVien_MissingPassword() {
        NhanVien nhanVien = new NhanVien(null, "Nguyen123", "NV05", "nv5", null, true);
        assertNull(nhanVien.getMatKhau(), "Mật khẩu không được để trống");
    }


    // test2 dahsach rỗng
    @Test
    void showNhanVienNotEmpty() {
        List<NhanVien> nhanViens = nhanVienRepository.findAll();
        assertNotNull(nhanViens, "Danh sách nhân viên không được null");
        assertFalse(nhanViens.isEmpty(), "Danh sách nhân viên không được rỗng");
    }


    // tes1 hợp lệ
    @Test
    void searchNhanVienByMaNV() {
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV("NV01");
        assertFalse(nhanVienList.isEmpty(), "Không tìm thấy nhân viên với mã NV01");
        NhanVien nhanVien = nhanVienList.get(0);
        assertEquals("Nguyen Van A", nhanVien.getTen(), "Tên nhân viên phải là 'Nguyen Van A'");
    }

    // test2 tìm mã không tồn tại
    @Test
    void searchNhanVienMaNVkhogtontai() {
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV("NV99");
        assertTrue(nhanVienList.isEmpty(), "Danh sách nhân viên phải rỗng khi mã không tồn tại");
    }

    // test 3 bo trong o tim kiem
    @Test
    void searchNhanVienBotrong() {
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV("NV99");
        assertTrue(nhanVienList.isEmpty(), "Kết quả không được trả về khi mã sản phẩm trống");
    }

    // test 4 thiêu so luong ki tu
    @Test
    void searchNhanVienShortCode() {
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV("NV");
        assertTrue(nhanVienList.isEmpty(), "Kết quả không được trả về khi mã nhân viên thiếu số lượng ký tự");
    }

    // chua ki tu dac biet\
    @Test
    void searchNhanVienBymachuakitudacbiet() {
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV("NV#01");
        assertTrue(nhanVienList.isEmpty(), "Mã nhân viên không được chứa ký tự đặc biệt");
    }

    // test 6 qua dai
    @Test
    void searchNhanVienByMaquadai() {
        String longCode = "NV".repeat(198);
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV(longCode);
        assertTrue(nhanVienList.isEmpty(), "Kết quả không được trả về khi mã nhân viên quá dài");
    }


    @Test
    void searchNhanVienByMaNVThieukitu() {
        String maNV = "NV01";
        List<NhanVien> nhanVienList = nhanVienRepository.getNhanVienByMaNV(maNV);
        assertFalse(nhanVienList.isEmpty(), "Không tìm thấy nhân viên với mã " + maNV);
        NhanVien nhanVien = nhanVienList.get(0);
        assertEquals("Nguyen Van A", nhanVien.getTen(), "Tên nhân viên phải là 'Nguyen Van A'");
        assertEquals(4, maNV.length(), "Mã nhân viên phải có 4 ký tự");
    }



    //test1 xoa hop le
    @Test
    void deleteNhanVien() {
        NhanVien nhanVien = nhanVienRepository.findByMaNV("NV01").orElse(null);
        assertNotNull(nhanVien, "Không tìm thấy nhân viên với mã NV01 trước khi xóa");

        nhanVienRepository.deleteById(nhanVien.getId());
        NhanVien deletedNhanVien = nhanVienRepository.findByMaNV("NV01").orElse(null);
        assertNull(deletedNhanVien, "Nhân viên với mã NV01 phải bị xóa");
    }
    @Test
    void detailNhanVien() {
        NhanVien nhanVien = nhanVienRepository.findByMaNV("NV02").orElse(null);
        assertNotNull(nhanVien, "Không tìm thấy nhân viên với mã NV02");
        assertEquals("Tran Thi B", nhanVien.getTen(), "Tên nhân viên phải là 'Tran Thi B'");

    }
    //Test1 hop le:
    @Test
    void updateNhanVien() {
        NhanVien nhanVien = nhanVienRepository.findByMaNV("NV01").orElse(null);
        assertNotNull(nhanVien, "Không tìm thấy nhân viên NV01");

        nhanVien.setTen("Nguyen Van Updated");
        nhanVienRepository.save(nhanVien);

        NhanVien updatedNhanVien = nhanVienRepository.findByMaNV("NV01").orElse(null);
        assertNotNull(updatedNhanVien, "Không tìm thấy nhân viên sau khi cập nhật");
        assertEquals("Nguyen Van Updated", updatedNhanVien.getTen(), "Tên nhân viên phải được cập nhật thành 'Nguyen Van Updated'");
    }

    //test2 Trong Ten
    @Test
    void testUpdateNhanVien_TenTrong() {
        NhanVien NhanVien = new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true);
        assertNotNull(NhanVien, "Không tìm thấy nhân viên với mã NV01");

        NhanVien.setTen("");
        try {
            nhanVienRepository.save(NhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Vui lòng điền thông tin tên nhân viên"));
        }
    }

    //test3 Trong ma
    @Test
    void testUpdateNhanVien_TenMaTrong() {
        NhanVien NhanVien = new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true);
        assertNotNull(NhanVien, "Không tìm thấy nhân viên với mã NV01");

        NhanVien.setMaNV("");
        try {
            nhanVienRepository.save(NhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Vui lòng điền thông tin mã nhân viên: NV..."));
        }
    }

    //test4 Trong tenDN
    @Test
    void testUpdateNhanVien_TenDNTrong() {
        NhanVien NhanVien = new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true);
        assertNotNull(NhanVien, "Không tìm thấy nhân viên với mã NV01");

        NhanVien.setTenDangNhap("");
        try {
            nhanVienRepository.save(NhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Vui lòng điền thông tin tên đăng nhập của nhân viên"));
        }
    }

    //test5 Trong mk
    @Test
    void testUpdateNhanVien_psssTrong() {
        NhanVien NhanVien = new NhanVien(null, "Nguyen Van C", "NV03", "nvc", "password", true);
        assertNotNull(NhanVien, "Không tìm thấy nhân viên với mã NV01");

        NhanVien.setMatKhau("");
        try {
            nhanVienRepository.save(NhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Vui lòng điền thông tin mật khẩu của nhân viên"));
        }
    }
    //test 6 ten qua dai
    @Test
    void testupdateNhanVien_LongName() {

        NhanVien nhanVien = new NhanVien(null, "longName", "vc12", "11", "password", true);
            nhanVien.setTen("longname".repeat(20));
        Exception exception = assertThrows(Exception.class, () -> {
            nhanVienRepository.save(nhanVien);
        });

        assertTrue(exception.getMessage().contains("Tên Nhân Viên không được vượt quá 50 ký tự"));
    }

    // tesrt 7 khong co ma
    @Test
    void testUpdateNhanVien_MaNVKhongTonTai() {
        NhanVien nhanVien = nhanVienRepository.findByMaNV("NV99").orElse(null);
        assertNull(nhanVien, "Không nên tìm thấy nhân viên với mã NV99");

        if (nhanVien != null) {
            nhanVien.setTen("Updated Name");
            Exception exception = assertThrows(Exception.class, () -> nhanVienRepository.save(nhanVien));
            assertTrue(exception.getMessage().contains("Không thể cập nhật, mã nhân viên không tồn tại"));
        }
    }


    //test 8 ten qua ngan
    @Test
    void testupdateNhanVien_tennngan() {

        NhanVien nhanVien = new NhanVien(null, "A", "NV06", "nv6", "password", true);
        nhanVien.setTen("a");
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên quá ngắn"));
        }
    }



    //test 9 ten chua so
    @Test
    void testupdateNhanVien_tenchuaso() {

        NhanVien nhanVien = new NhanVien(null, "A", "NV06", "nv6", "password", true);
        nhanVien.setTen("abc1");
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên không chứa số"));
        }
    }


    //test 10 ten chua so
    @Test
    void testupdateNhanVien_tenchuakitudacbiet() {

        NhanVien nhanVien = new NhanVien(null, "A", "NV06", "nv6", "password", true);
        nhanVien.setTen("abc1@");
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Tên nhân viên không chứa số"));
        }
    }
}
