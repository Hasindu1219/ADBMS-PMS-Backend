package com.pms.PharmacyMS.service;


import com.pms.PharmacyMS.dto.SupplierDto;
import com.pms.PharmacyMS.model.Supplier;
import com.pms.PharmacyMS.repository.SupplierRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private ModelMapper modelMapper;

    public SupplierDto addSupplier(SupplierDto supplierDto) {
        supplierRepo.save(modelMapper.map( supplierDto, Supplier.class));
        return  supplierDto;
    }

}
