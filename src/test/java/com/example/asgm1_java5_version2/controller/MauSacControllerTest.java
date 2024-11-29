package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.MauSac;
import com.example.asgm1_java5_version2.model.SanPham;
import com.example.asgm1_java5_version2.repository.MauSacRepository;
import jakarta.servlet.http.PushBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Rollback
 class MauSacControllerTest {
    @Autowired
    private MauSacController mauSacController;

    @Autowired
    private MauSacRepository mauSacRepository;

    @BeforeEach
    void setUp() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));
    }


    @AfterEach
    void tearDown() {
        mauSacRepository.deleteAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataAddMauSacSuccess.csv")


    // add màu sắc hợp lệ
    @Test
    void addMauSac_HopLe(String ma, String ten, boolean trangThai) {
        //tạo đối tượng mới
        MauSac mauSacNew = new MauSac(null, ma, ten, trangThai);

        //lưu vào csdl
        mauSacRepository.save(mauSacNew);

        MauSac result = mauSacRepository.findById(mauSacNew.getId()).orElse(null);
        assertEquals(ma, result.getMa());
        assertEquals(ten, result.getTen());
        assertEquals(trangThai, result.isTrangThai());
    }

    // mã màu sắc bị trùng
    @Test
    void addMauSac_TrungMa() {
        MauSac mauSacNew = new MauSac(null,"MS01", "Bright", true);
        try{
            mauSacRepository.save(mauSacNew);
        }catch (Exception e){
            assertEquals(true, e.getMessage().contains("Mã màu sắc bị trùng"));
        }
    }

    // mã màu sắc để trống
    @Test
    void addMauSac_MaTrong() {
        MauSac mauSacNew = new MauSac(null,"", "Ocean Blue", true);
        try{
            mauSacRepository.save(mauSacNew);
        }catch (Exception e){
            assertEquals(true, e.getMessage().contains("Vui lòng điền mã màu sắc"));
        }
    }

    // tên màu sắc để trống
    @Test
    void addMauSac_TenTrong() {
        MauSac mauSacNew = new MauSac(null,"MS03", "", false);
        try {
            mauSacRepository.save(mauSacNew);
        }catch (Exception e){
            assertEquals(true, e.getMessage().contains("Vui lòng điền tên màu sắc"));
        }
    }

    // trạng thái không chọn
    @Test
    void addMauSac_TrangThaiNull() {
        MauSac mauSacNew = new MauSac(null,"MS04", "Sunny Yellow", false);
        try {
            mauSacRepository.save(mauSacNew);
        }catch (Exception e){
            assertEquals(true, e.getMessage().contains("Vui lòng chọn trạng thái"));
        }

    }

    // mã chứa kí tự đặc biệt
    @Test
    void addMauSac_MaChuaKiTuDacBiet() {
            MauSac mauSacNew = new MauSac(null,"MS#05", "Midnight Black", true);
            try {
                mauSacRepository.save(mauSacNew);
            }catch (Exception e){
                assertEquals(true, e.getMessage().contains("Mã màu sắc không chứa ký tự đặc biệt"));
            }


    }

    // tên chứa kí tự đặc biệt
    @Test
    void addMauSac_TenChuaKiTuDacBiet() {
        MauSac mauSacNew = new MauSac(null,"MS06", "Snow White@", false);
        try {
            mauSacRepository.save(mauSacNew);
        }catch (Exception e){
            assertEquals(true, e.getMessage().contains("Tên màu sắc không chứa ký tự đặc biệt"));
        }
    }

    // mã có dữ liệu lớn > 256 ký tự
    @Test
    void addMauSac_MaCoDuLieuLon() {
        String longMa = "MS07".repeat(50);
        MauSac mauSacNew = new MauSac(null, longMa, "Burnt Orange", true);
        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(mauSacNew);
        });

        assertTrue(exception.getMessage().contains("Mã màu sắc không được vượt quá 256 ký tự"));
    }

    // tên có dữ liệu lớn > 256 ký tự
    @Test
    void addMauSac_TenCoDuLieuLon() {
        String longTen = "Royal Purple".repeat(50);
        MauSac mauSacNew = new MauSac(null, "MS08", longTen, true);
        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(mauSacNew);
        });

        assertTrue(exception.getMessage().contains("Tên màu sắc không được vượt quá 256 ký tự"));
    }


    // update màu sắc hợp lệ
    @Test
    void updateMauSac_HopLe() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        // lấy màu sắc trong cơ sở dữ liệu
        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        // cập nhật tên màu sắc
        exitMauSac.setTen("Bright Red");

        // lưu lại màu sắc đã được sửa
        mauSacRepository.save(exitMauSac);

        // lấy lại màu sắc trong csdl để kiểm tra
        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        // kiểm tra thông tin tên màu sắc đã được cập nhật
        assertEquals("Bright Red", result.getTen());
        assertEquals(true, result.isTrangThai());
    }


    // update mã để trống
    @Test
    void updateMauSac_MaDeTrong() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        exitMauSac.setMa("");

        mauSacRepository.save(exitMauSac);

        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        assertEquals("", result.getMa());
        assertEquals("Bright Red", result.getTen());
        assertEquals(true, result.isTrangThai());
    }

    // update tên để trống
    @Test
    void updateMauSac_TenDeTrong() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        exitMauSac.setTen("");

        mauSacRepository.save(exitMauSac);

        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        assertEquals("MS01", result.getMa());
        assertEquals("", result.getTen());
        assertEquals(true, result.isTrangThai());
    }

    // update trạng thái sai
    @Test
    void updateMauSac_TrangThaiSai() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        exitMauSac.setTrangThai(false);

        mauSacRepository.save(exitMauSac);

        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        assertEquals("MS01", result.getMa());
        assertEquals("Bright Red", result.getTen());
        assertEquals(true, result.isTrangThai());
    }

    // update mã có chứa ký tự đặc biệt
    @Test
    void updateMauSac_MaChuaKyTuDacBiet() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        exitMauSac.setMa("MS#01");

        mauSacRepository.save(exitMauSac);

        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        assertEquals("MS#01", result.getMa());
        assertEquals("Bright Red", result.getTen());
        assertEquals(true, result.isTrangThai());
    }

    // update tên có chứa ký tự đặc biệt
    @Test
    void updateMauSac_TenChuaKyTuDacBiet() {
        mauSacRepository.save(new MauSac(null, "MS01", "Bright Red", true));
        mauSacRepository.save(new MauSac(null, "MS02", "Ocean Blue", true));

        MauSac exitMauSac = mauSacRepository.getMauSacByMa("MS001").get(0);

        exitMauSac.setTen("Bright Red@");

        mauSacRepository.save(exitMauSac);

        MauSac result = mauSacRepository.findById(exitMauSac.getId()).orElse(null);

        assertEquals("MS01", result.getMa());
        assertEquals("Bright Red@", result.getTen());
        assertEquals(true, result.isTrangThai());
    }





}