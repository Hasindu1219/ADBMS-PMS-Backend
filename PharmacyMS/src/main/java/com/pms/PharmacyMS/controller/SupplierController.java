package com.pms.PharmacyMS.controller;

import com.pms.PharmacyMS.dto.SupplierDto;
import com.pms.PharmacyMS.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addsupplier")
    public SupplierDto addSupplier(@RequestBody SupplierDto supplierDto) {
        return  supplierService.addSupplier(supplierDto);
    }

}
