package com.example.asgm1_java5_version2.repository;

import com.example.asgm1_java5_version2.model.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM KichThuoc WHERE ma LIKE %:ma%"
    )

    ArrayList<KichThuoc> getKichThuocByMa(String ma);

    // Thêm phương thức phân trang
    Page<KichThuoc> findAll(Pageable pageable);
}
