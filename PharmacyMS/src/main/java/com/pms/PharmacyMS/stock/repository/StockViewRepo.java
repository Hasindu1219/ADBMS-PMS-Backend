package com.pms.PharmacyMS.stock.repository;

import com.pms.PharmacyMS.stock.entity.StockViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockViewRepo extends JpaRepository<StockViewEntity,Integer> {
}
