package com.pms.PharmacyMS.suppliers.controllor;


import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping("/getsuppliers")
    public List<SupplierDto> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/addsupplier")
    public SupplierDto addSupplier(@RequestBody SupplierDto supplierDto) {
        return  supplierService.addSupplier(supplierDto);
    }

    @PutMapping("/updatesupplier/{id}")
    public SupplierDto updateSupplier(@PathVariable int id, @RequestBody SupplierDto supplierDto) {
        return supplierService.updateSupplier(id,supplierDto);
    }
}
