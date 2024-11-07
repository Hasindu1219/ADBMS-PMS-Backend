package com.pms.PharmacyMS.suppliers.repository;

import com.pms.PharmacyMS.suppliers.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

 @Procedure(name = "sp_updateSupplier")
    void sp_updateSupplier(int p_supplier_id, String p_supplier_name, String p_sale_rep_name,
                        String p_address, String p_phone_number, String p_email);
}
