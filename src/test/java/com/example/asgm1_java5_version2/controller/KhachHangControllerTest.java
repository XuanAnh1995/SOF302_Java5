package com.example.asgm1_java5_version2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KhachHangControllerTest {

    @Autowired
    KhachHangController khachHangController;

    @BeforeMethod
    public void setUp() {
        //đăng nhập
        //lấy link -> nhập user -> nhập pass ->
        //lấy link khachhang/show
    }

    @AfterMethod
    public void tearDown() {
        khachHangController = null;
    }

    @Test //add
    public void testShowFormAdd() {
        //lấy xpath của nút add -> click
        // thêm các trường dự liệu
        //click btn Add

    }

    @Test
    public void testAddKhachHang() {
    }
}