package com.example.asgm1_java5_version2.controller;

import com.example.asgm1_java5_version2.model.MauSac;
import com.example.asgm1_java5_version2.repository.MauSacRepository;
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
class MauSacTest {

    @Autowired
    private MauSacRepository mauSacRepository;

    @BeforeEach
    void setUp() {
        mauSacRepository.deleteAll();
        mauSacRepository.save(new MauSac(null, "MS001", "Red", true));
        mauSacRepository.save(new MauSac(null, "MS002", "Blue", false));
    }

    @Test
    void testAddMauSacHopLe() {
        MauSac newMauSac = new MauSac(null, "MS003", "Green", true);
        mauSacRepository.save(newMauSac);

        MauSac result = mauSacRepository.findById(newMauSac.getId()).orElse(null);

        assertEquals("MS003", result.getMa());
        assertEquals("Green", result.getTen());
        assertTrue(result.isTrangThai());
    }

    @Test
    void testAddMauSac_MaEmpty() {
        MauSac newMauSac = new MauSac(null, "", "Yellow", true);

        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(newMauSac);
        });

        assertTrue(exception.getMessage().contains("Vui lòng điền thông tin mã màu sắc"));
    }

    @Test
    void testAddMauSac_TenEmpty() {
        MauSac newMauSac = new MauSac(null, "MS004", "", true);

        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(newMauSac);
        });

        assertTrue(exception.getMessage().contains("Vui lòng điền thông tin tên màu"));
    }

    @Test
    void testAddMauSac_MaTooShort() {
        MauSac newMauSac = new MauSac(null, "M1", "Purple", true);

        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(newMauSac);
        });

        assertTrue(exception.getMessage().contains("Mã màu sắc phải có độ dài từ 3 đến 10 ký tự"));
    }

    @Test
    void testAddMauSac_DuplicateMa() {
        mauSacRepository.save(new MauSac(null, "MS005", "Pink", true));

        MauSac duplicateMauSac = new MauSac(null, "MS005", "Black", false);

        Exception exception = assertThrows(Exception.class, () -> {
            mauSacRepository.save(duplicateMauSac);
        });

        assertTrue(exception.getMessage().contains("Trùng mã màu sắc"));
    }

    @Test
    void testUpdateMauSac() {
        MauSac existingMauSac = mauSacRepository.findById(1).orElse(null);
        assertNotNull(existingMauSac);

        existingMauSac.setTen("Updated Red");
        existingMauSac.setTrangThai(false);

        mauSacRepository.save(existingMauSac);

        MauSac updatedMauSac = mauSacRepository.findById(1).orElse(null);
        assertNotNull(updatedMauSac);
        assertEquals("Updated Red", updatedMauSac.getTen());
        assertFalse(updatedMauSac.isTrangThai());
    }


}
