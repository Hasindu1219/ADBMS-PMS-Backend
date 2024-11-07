package com.pms.PharmacyMS.suppliers.service;


import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.Supplier;
import com.pms.PharmacyMS.suppliers.entity.SupplierView;
import com.pms.PharmacyMS.suppliers.repository.SupplierRepo;
import com.pms.PharmacyMS.suppliers.repository.SupplierViewRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SupplierViewRepo supplierViewRepo;




// get all suppliers from SupplierView
public List<SupplierView> getAllSuppliersFromView() {
    return supplierViewRepo.findAll();
}

// add new supplier
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        supplierRepo.save(modelMapper.map( supplierDto, Supplier.class));
        return  supplierDto;
    }

// get supplier by ID
    public SupplierDto getSupplierById(int id) {
        // Fetch the supplier from the database by ID
        Supplier supplier = supplierRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));

        return modelMapper.map(supplier, SupplierDto.class);
    }

// update supplier
    public  void sp_updateSupplier(int supplierId,String supplierName,String address,String phoneNumber,String saleRepName,String email) {
        supplierRepo.sp_updateSupplier(supplierId,supplierName,address,phoneNumber,saleRepName,email);
    }
}
