package com.example.asgm1_java5_version2.repository;

import com.example.asgm1_java5_version2.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    @Query(nativeQuery = true,
    value = "SELECT * FROM MauSac WHERE ma LIKE %:ma%"
    )

    ArrayList<MauSac> getMauSacByMa(String ma);

    // Thêm phương thức phân trang
    Page<MauSac> findAll(Pageable pageable);
}
