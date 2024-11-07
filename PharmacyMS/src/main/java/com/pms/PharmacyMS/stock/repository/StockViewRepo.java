package com.pms.PharmacyMS.stock.repository;

import com.pms.PharmacyMS.stock.entity.StockViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockViewRepo extends JpaRepository<StockViewEntity,Integer> {
    @Procedure(name = "sales_stock_view")
    List<StockViewEntity> sales_stock_view(@Param("inputBranchId") Integer inputBranchId);
}
