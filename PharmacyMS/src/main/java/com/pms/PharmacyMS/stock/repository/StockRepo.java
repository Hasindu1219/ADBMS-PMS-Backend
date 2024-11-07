package com.pms.PharmacyMS.stock.repository;


import com.pms.PharmacyMS.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StockRepo extends JpaRepository<StockEntity,Integer> {
//    @Transactional
//    @Procedure(name = "sp_DeleteMedicine")
//    String deleteMedicine(@Param("medId") Long medId);


}
