package com.pms.PharmacyMS.ReportGenerate.Repo;

import com.pms.PharmacyMS.ReportGenerate.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    @Procedure(name = "getPurchaseHistory")
     List<Object[]> getPurchaseHistory(int branchId, int month, int year);

    @Procedure(name = "getExpiryTracking")
    List<Object[]> getExpiryTracking(int branchId);
}
