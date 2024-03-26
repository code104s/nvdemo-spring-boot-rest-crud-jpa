package com.offlink112.nvdemo.rest;

import com.offlink112.nvdemo.entity.NhanVien;
import com.offlink112.nvdemo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NhanVienRestController {
    private NhanVienService nhanVienService;
    // quick and dirty : inject employee dao (use constructor injection)

    @Autowired
    public NhanVienRestController(NhanVienService theNhanVienService) {
        nhanVienService = theNhanVienService;
    }

    @GetMapping("/nhanvien")
    public List<NhanVien> findAll() {
        return nhanVienService.findAll();
    }


    // add mapping for GET /
    @GetMapping("/nhanvien/{nhanvienId}")
    public  NhanVien getNhanVien(@PathVariable int nhanvienId) {
        NhanVien theNhanVien = nhanVienService.findById(nhanvienId);

        if(theNhanVien == null)  {
            throw new RuntimeException("id not found - " + nhanvienId);
        }

        return theNhanVien;
    }

    // add mapping for POST / employee - add new employee
    @PostMapping("/nhanvien")
    public NhanVien addNhanVien(@RequestBody NhanVien theNhanVien) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theNhanVien.setId(0);

        NhanVien dbNhanVien = nhanVienService.save(theNhanVien);
        return dbNhanVien;
    }

    // add mapping for PUT ( update employee)

    @PutMapping("/nhanvien")
    public NhanVien updateNhanVien(@RequestBody NhanVien theNhanVien) {

        NhanVien dbNhanVien = nhanVienService.save(theNhanVien);
        return dbNhanVien;
    }

    // add mapping for DELETED
    @DeleteMapping("/nhanvien/{nhanvienId}")
    public String deletedNhanVien(@PathVariable int nhanvienId) {
        NhanVien tempNhanVien = nhanVienService.findById(nhanvienId);

        if(tempNhanVien == null) {
            throw new RuntimeException("id not found" + nhanvienId);
        }
        nhanVienService.deletedById(nhanvienId);

        return "Deleted nhanvien id - " + nhanvienId;
    }
}
