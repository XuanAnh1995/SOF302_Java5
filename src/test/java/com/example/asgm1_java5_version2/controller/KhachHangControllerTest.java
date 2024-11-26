package com.example.asgm1_java5_version2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KhachHangControllerTest {

    @Autowired
    private KhachHangController khachHangController;

    @BeforeMethod
    public void setUp() {
        khachHangController = new KhachHangController();
    }

    @AfterMethod
    public void tearDown() {
        khachHangController = null;
    }

    @Test
    public void testShowFormAdd() {

    }

    @Test
    public void testAddKhachHang() {
    }
}