package com.pms.PharmacyMS.suppliers.service;


import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.Supplier;
import com.pms.PharmacyMS.suppliers.repository.SupplierRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<SupplierDto> getAllSuppliers() {
        return supplierRepo.findAll().stream()
                .map(supplier -> modelMapper.map(supplier, SupplierDto.class))
                .collect(Collectors.toList());
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
