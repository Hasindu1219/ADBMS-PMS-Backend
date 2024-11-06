package com.pms.PharmacyMS.suppliers.controllor;


import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.SupplierView;
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

    // Fetch all suppliers
    @GetMapping("/getsuppliers")
    public List<SupplierView> getAllSuppliersFromView() {
        return  supplierService.getAllSuppliersFromView();
    }

    //Fetch supplier by ID
    @GetMapping("getSupplierById/{id}")
    public SupplierDto getSupplierById(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    // add supplier
    @PostMapping("/addsupplier")
    public SupplierDto addSupplier(@RequestBody SupplierDto supplierDto) {
        return  supplierService.addSupplier(supplierDto);
    }

    // update supplier
    @PutMapping("/updatesupplier/{id}")
    public SupplierDto updateSupplier(@PathVariable int id, @RequestBody SupplierDto supplierDto) {
        return supplierService.updateSupplier(id,supplierDto);
    }
}
