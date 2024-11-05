package com.pms.PharmacyMS.ReportGenerate.Repo;

import com.pms.PharmacyMS.ReportGenerate.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Integer> {
    @Procedure(name = "getInventoryLevel")
    List<Object[]> getInventoryLevel(int branch_id);

    @Procedure(name="getLowStockItems")
    List<Object[]> getLowStockItems(int branch_id);

    @Procedure(name = "getExpiryTracking")
    List<Object[]> getExpiryTracking(int branch_id);

}
