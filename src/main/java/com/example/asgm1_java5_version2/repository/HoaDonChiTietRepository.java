package com.example.asgm1_java5_version2.repository;

import com.example.asgm1_java5_version2.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM HoaDonChiTiet WHERE idHoaDon = ?"
    )

    List<HoaDonChiTiet> getHoaDonChiTietByHoaDonId(Integer idHoaDon);

    HoaDonChiTiet findSingleBySanPhamChiTietIdAndHoaDonId(Integer sanPhamChiTietId, Integer hoaDonId);

    List<HoaDonChiTiet> findBySanPhamChiTietIdAndHoaDonId(Integer sanPhamChiTietId, Integer idUpdate);

    void deleteBySanPhamChiTietId(Integer sanPhamChiTietId);

    List<HoaDonChiTiet> findAllBySanPhamChiTietIdAndHoaDonId(Integer sanPhamChiTietId, Integer id);

    // Thêm phương thức phân trang
    Page<HoaDonChiTiet> findAll(Pageable pageable);
}
