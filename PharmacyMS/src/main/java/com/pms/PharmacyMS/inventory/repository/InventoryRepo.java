package com.pms.PharmacyMS.inventory.repository;


import com.pms.PharmacyMS.inventory.dto.InventoryViewDto;
import com.pms.PharmacyMS.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    // View the Inventory Data
//    @Query("SELECT new com.pms.PharmacyMS.dto.InventoryViewDto(" +
//            "s.supplierName, s.saleRepName, s.phoneNumber, i.quantity, i.receivedDate, i.price) " +
//            "FROM Inventory i JOIN Supplier s ON i.supplierId = s.supplierId " +
//            "ORDER BY s.supplierId ASC")
   // List<InventoryViewDto> findAllInventoryView();
// InventoryRepo.java
//    @Query("SELECT new com.pms.PharmacyMS.dto.InventoryViewDto(" +
//            "i.inventoryId, i.medicineId, i.supplierId, s.supplierName, s.saleRepName, s.phoneNumber, " +
//            "i.quantity, i.receivedDate, i.price) " +
//            "FROM Inventory i JOIN Supplier s ON i.supplierId = s.supplierId " +
//            "ORDER BY s.supplierId ASC")
//    List<InventoryViewDto> findAllInventoryView();

    // InventoryRepo.java
    @Query("SELECT new com.pms.PharmacyMS.inventory.dto.InventoryViewDto(" +
            "i.inventoryId, i.medicineId, i.supplierId, s.supplierName, s.saleRepName, s.phoneNumber, " +
            "i.quantity, i.receivedDate, i.price) " +
            "FROM Inventory i JOIN Supplier s ON i.supplierId = s.supplierId " +
            "ORDER BY s.supplierId ASC")
    List<InventoryViewDto> findAllInventoryView();



}
