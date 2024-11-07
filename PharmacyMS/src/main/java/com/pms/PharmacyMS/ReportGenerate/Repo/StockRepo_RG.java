package com.pms.PharmacyMS.ReportGenerate.Repo;

import com.pms.PharmacyMS.ReportGenerate.Entity.Stock_RG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface StockRepo_RG extends JpaRepository<Stock_RG, Integer> {
    @Procedure(name = "getInventoryLevel")
    List<Object[]> getInventoryLevel(int branch_id);

    @Procedure(name="getLowStockItems")
    List<Object[]> getLowStockItems(int branch_id);


}
