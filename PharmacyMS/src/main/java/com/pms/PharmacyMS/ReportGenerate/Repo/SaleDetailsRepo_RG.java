package com.pms.PharmacyMS.ReportGenerate.Repo;

import com.pms.PharmacyMS.ReportGenerate.Entity.SaleDetails_RG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailsRepo_RG extends JpaRepository<SaleDetails_RG, Integer> {
    @Query(value = "CALL sp_BranchdailySales(:selected_date,:branchID)", nativeQuery = true)
    List<Object[]> getBranchDailySales(@Param("selected_date") String selectedDate, @Param("branchID") int branchId);



//    @Query(value = "CALL sp_monthlySalesReport(:year, :month)", nativeQuery = true)
//    List<Object[]> getMonthlySalesReport(@Param("year") String year, @Param("month") String month);

    @Query(value = "CALL sp_dailySales(:selected_date)", nativeQuery = true)
    List<Object[]> getDailySales(@Param("selected_date") String selected_date);

    // Calling the stored procedure for monthly sales
    @Query(value = "CALL sp_monthlySales(:selected_month, :selected_year)", nativeQuery = true)
    List<Object[]> getMonthlySales(@Param("selected_month") int selectedMonth, @Param("selected_year") int selectedYear);

    // Calling the stored procedure for yearly sales
    @Query(value = "CALL sp_yearlySales(:selected_year)", nativeQuery = true)
    List<Object[]> getYearlySales(@Param("selected_year") int selectedYear);

    @Query(value="select * from TodaySales" ,nativeQuery = true)
    List<Object[]> getTodaySales();

    @Query(value="select * from MonthlySales" ,nativeQuery = true)
    List<Object[]> getThisMonthSales();

    @Query(value="select * from YearlySales" ,nativeQuery = true)
    List<Object[]> getThisYearSales();

    @Query(value = "SELECT * FROM View_Profit_Report", nativeQuery = true)
    List<Object[]> getViewProfitReport();
}

