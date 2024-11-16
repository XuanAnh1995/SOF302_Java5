package com.example.asgm1_java5_version2.repository;

import com.example.asgm1_java5_version2.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM KhachHang WHERE maKH LIKE %:maKH%"
    )

    ArrayList<KhachHang> getKhachHangByMa(String maKH);

    // Thêm phương thức phân trang
    Page<KhachHang> findAll(Pageable pageable);
}
