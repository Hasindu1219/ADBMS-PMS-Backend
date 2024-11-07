package com.pms.PharmacyMS.ReportGenerate.Controller;


import com.pms.PharmacyMS.ReportGenerate.Service.InventoryService_RG;
import com.pms.PharmacyMS.ReportGenerate.Service.SaleReportService_RG;
import com.pms.PharmacyMS.ReportGenerate.Service.StockService_RG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/report")
public class ReportGenerateController {

    @Autowired
    private SaleReportService_RG saleReportService;

    @Autowired
    private StockService_RG stockService;

    @Autowired
    private InventoryService_RG inventoryService;

//    http://localhost:8080/api/report/dailySales?selectedDate=2024-11-01
    @GetMapping("/dailySales")
    public List<Object[]> getDailySales(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String selectedDate,@RequestParam int branch_id) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(selectedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return saleReportService.getDailySales(date,branch_id);
    }

//    http://localhost:8080/api/report/monthlySales?selectedMonth=JANUARY&selectedYear=2024
    @GetMapping("/monthlySales")
    public List<Object[]> getMonthlySales(@RequestParam int selectedMonth,@RequestParam int selectedYear) {
        return saleReportService.getMonthlySales(selectedMonth,selectedYear);
    }

//    http://localhost:8080/api/report/stockLevel?branchId=1
    @GetMapping("/stockLevel")
    public List<Object[]> getInventoryLevel(@RequestParam("branchId") int branchId) {
        return stockService.getInventoryForBranch(branchId);
    }

    //    http://localhost:8080/api/report/lowstock?branchId=1
    @GetMapping("/lowstock")
    public List<Object[]> getLowStock(@RequestParam("branchId") int branchId) {
        return stockService.getLowStockItems(branchId);
    }

    //    http://localhost:8080/api/report/expiryTracking?branchId=1
    @GetMapping("/expiryTracking")
    public List<Object[]> getExpiryTracking(@RequestParam("branchId") int branchId) {
        return stockService.getExpiryTrackingData(branchId);
    }

    //    http://localhost:8080/api/report/purchaseHistory?branchId=1&month=&year=
    @GetMapping("/purchaseHistory")
    public List<Object[]> getPurchaseHistory(@RequestParam("branchId") int branchId,@RequestParam("month") int month,@RequestParam("year") int year) {
        return inventoryService.getPurchaseHistory(branchId,month,year);
    }

    //    http://localhost:8080/api/report/dailySales?selectedDate=2024-11-01
    @GetMapping("/dailySalesAllBranch")
    public List<Object[]> getDailySales(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String selectedDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(selectedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return saleReportService.getDailySales(date);
    }

    //    http://localhost:8080/api/report/dailySales?selectedYear=2024
    @GetMapping("/yearlySales")
    public List<Object[]> getYearlySales(@RequestParam("selectedYear") String selectedYear) {
        return saleReportService.getYearlySales(selectedYear);
    }

    //    http://localhost:8080/api/report/getTodaySales?option=
    @GetMapping("/getTodaySales")
    public List<Object[]> getTodaySales(@RequestParam("option") String option)
    {
        return saleReportService.getTodaySales(option);
    }

    //    http://localhost:8080/api/report/profitReport
    @GetMapping("/profitReport")
    public List<Object[]> getProfitReport() {
        return saleReportService.getProfitReport();
    }

}
