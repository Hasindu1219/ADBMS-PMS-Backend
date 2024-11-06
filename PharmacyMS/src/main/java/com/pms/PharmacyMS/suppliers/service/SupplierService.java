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
// Method to get all suppliers from SupplierView
public List<SupplierView> getAllSuppliersFromView() {
    return supplierViewRepo.findAll();
}
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        supplierRepo.save(modelMapper.map( supplierDto, Supplier.class));
        return  supplierDto;
    }
    public SupplierDto updateSupplier(int id, SupplierDto supplierDto) {
        // Check if the supplier exists
        Supplier existingSupplier = supplierRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));

        // Update supplier details
        existingSupplier.setSupplierName(supplierDto.getSupplierName());
        existingSupplier.setSaleRepName(supplierDto.getSaleRepName());
        existingSupplier.setAddress(supplierDto.getAddress());
        existingSupplier.setPhoneNumber(supplierDto.getPhoneNumber());
        existingSupplier.setEmail(supplierDto.getEmail());

        // Save updated supplier
        Supplier updatedSupplier = supplierRepo.save(existingSupplier);

        // Convert updated supplier to SupplierDto
        return modelMapper.map(updatedSupplier, SupplierDto.class);
    }

}
