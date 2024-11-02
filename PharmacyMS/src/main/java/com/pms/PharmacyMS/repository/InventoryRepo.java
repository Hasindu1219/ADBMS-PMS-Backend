package com.pms.PharmacyMS.repository;

import com.pms.PharmacyMS.dto.InventoryDto;
import com.pms.PharmacyMS.dto.InventoryViewDto;
import com.pms.PharmacyMS.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    @Query("SELECT new com.pms.PharmacyMS.dto.InventoryViewDto ( i.quantity, i.receivedDate, i.price) FROM Inventory i")
    List<InventoryViewDto> findAllInventoryView();


    @Modifying
    @Query("UPDATE Stock s SET s.stockQuantity = s.stockQuantity + :quantity WHERE s.medicineId = :medicineId")
    void updateStockQuantity(int quantity,int medicineId);
}
