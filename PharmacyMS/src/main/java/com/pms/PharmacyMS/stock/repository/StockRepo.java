package com.pms.PharmacyMS.stock.repository;


import com.pms.PharmacyMS.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StockRepo extends JpaRepository<StockEntity,Integer> {

    @Procedure(procedureName = "sp_UpdateStockSalePrice")
    String sp_UpdateStockSalePrice(int med_id, double p_new_price);

}
