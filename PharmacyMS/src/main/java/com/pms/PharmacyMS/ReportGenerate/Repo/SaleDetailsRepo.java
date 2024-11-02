package com.pms.PharmacyMS.ReportGenerate.Repo;

import com.pms.PharmacyMS.ReportGenerate.Entity.SaleDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public interface SaleDetailsRepo extends JpaRepository<SaleDetails, Integer> {
    @Query(value = "CALL sp_dailySales(:selected_date)", nativeQuery = true)
    List<Object[]> getDailySales(@Param("selected_date") Date selectedDate);

    @Query(value = "CALL sp_monthlySalesReport(:year, :month)", nativeQuery = true)
    List<Object[]> getMonthlySalesReport(@Param("year") Year year, @Param("month") Month month);
}

