package com.offlink112.nvdemo.service;

import com.offlink112.nvdemo.entity.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NhanVienService {
    List<NhanVien> findAll();

    NhanVien findById(int theId);

    NhanVien save(NhanVien theNhanVien);

    void deletedById(int theId);

}
