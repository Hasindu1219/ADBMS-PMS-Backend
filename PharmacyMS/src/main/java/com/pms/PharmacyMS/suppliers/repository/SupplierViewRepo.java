package com.pms.PharmacyMS.suppliers.repository;

import com.pms.PharmacyMS.suppliers.entity.SupplierView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SupplierViewRepo extends JpaRepository<SupplierView,Integer> {
}
