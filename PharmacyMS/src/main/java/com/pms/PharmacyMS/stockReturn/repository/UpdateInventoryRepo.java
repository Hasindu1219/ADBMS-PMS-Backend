package com.pms.PharmacyMS.stockReturn.repository;

import com.pms.PharmacyMS.stockReturn.entity.GetInventoryEntity;
import com.pms.PharmacyMS.stockReturn.entity.UpdateInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface UpdateInventoryRepo extends JpaRepository<UpdateInventoryEntity,Integer> {

    @Procedure(name = "sp_AddToStockArchive")
    void sp_AddToStockArchive(int p_stock_quantity, int p_medicine_id, int p_branch_id, java.sql.Timestamp p_expiry_date);
}
