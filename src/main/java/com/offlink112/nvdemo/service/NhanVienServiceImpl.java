package com.offlink112.nvdemo.service;

import com.offlink112.nvdemo.dao.NhanVienRespository;
import com.offlink112.nvdemo.entity.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService{

    private NhanVienRespository nhanVienRespository;
    @Autowired
    public NhanVienServiceImpl(NhanVienRespository theNhanVienRespository) {
        nhanVienRespository = theNhanVienRespository;
    }
    @Override
    public List<NhanVien> findAll() {
        return nhanVienRespository.findAll();
    }

    @Override
    public NhanVien findById(int theId) {
        Optional<NhanVien> result = nhanVienRespository.findById(theId);
        NhanVien theNhanVien = null;
        if(result.isPresent()) {
            theNhanVien = result.get();
        } else {
            throw new RuntimeException("Did not find nhanvien id - " + theId);
        }
        return theNhanVien;
    }


    @Override
    public NhanVien save(NhanVien theNhanVien) {
        return nhanVienRespository.save(theNhanVien);
    }

    @Override
    public void deletedById(int theId) {
        nhanVienRespository.deleteById(theId);
    }
}
