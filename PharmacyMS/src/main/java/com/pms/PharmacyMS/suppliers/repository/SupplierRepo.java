package com.pms.PharmacyMS.suppliers.repository;

import com.pms.PharmacyMS.suppliers.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}
