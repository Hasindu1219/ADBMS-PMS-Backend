package com.pms.PharmacyMS.suppliers.service;


import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.Supplier;
import com.pms.PharmacyMS.suppliers.entity.SupplierView;
import com.pms.PharmacyMS.suppliers.repository.SupplierRepo;
import com.pms.PharmacyMS.suppliers.repository.SupplierViewRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
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

    @Autowired
    private EntityManager entityManager;


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
    public  SupplierDto updateSupplier(int id,SupplierDto supplierDto){
        StoredProcedureQuery query=entityManager.createStoredProcedureQuery("sp_updateSupplier");
        query.registerStoredProcedureParameter("p_supplier_id", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_supplier_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_sale_rep_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_address", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_phone_number", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);

        // Set parameters for the stored procedure
        query.setParameter("p_supplier_id", id);
        query.setParameter("p_supplier_name", supplierDto.getSupplierName());
        query.setParameter("p_sale_rep_name", supplierDto.getSaleRepName());
        query.setParameter("p_address", supplierDto.getAddress());
        query.setParameter("p_phone_number", supplierDto.getPhoneNumber());
        query.setParameter("p_email", supplierDto.getEmail());


        query.execute();
        return supplierDto;
    }
}
