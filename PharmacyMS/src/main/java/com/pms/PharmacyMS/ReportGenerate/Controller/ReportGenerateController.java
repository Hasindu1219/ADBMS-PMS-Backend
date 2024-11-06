package com.pms.PharmacyMS.ReportGenerate.Controller;


import com.pms.PharmacyMS.ReportGenerate.Service.InventoryService;
import com.pms.PharmacyMS.ReportGenerate.Service.SaleReportService;
import com.pms.PharmacyMS.ReportGenerate.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/report")
public class ReportGenerateController {

    @Autowired
    private SaleReportService saleReportService;

    @Autowired
    private StockService stockService;

    @Autowired
    private InventoryService inventoryService;

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
    public List<Object[]> getMonthlySales(@RequestParam Month selectedMonth, Year selectedYear) {
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

}
