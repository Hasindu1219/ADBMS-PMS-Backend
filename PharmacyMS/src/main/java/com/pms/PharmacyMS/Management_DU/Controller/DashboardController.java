package com.pms.PharmacyMS.Management_DU.Controller;


import com.pms.PharmacyMS.Management_DU.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/today-sales")
    public Integer getTodaySalesCount() {
        return dashboardService.getTodaySalesCount();
    }

    @GetMapping("/today-income")
    public Double getTodayIncome() {
        return dashboardService.getTodayIncome();
    }

    @GetMapping("/yesterday-income-sales")
    public Map<String, Object> getYesterdayIncomeAndSales() {
        return dashboardService.getYesterdayIncomeAndSales();
    }

    @GetMapping("/monthly-income-sales")
    public List<Map<String, Object>> getMonthlyIncomeAndSales() {
        return dashboardService.getMonthlyIncomeAndSales();
    }

    @GetMapping("/goods-near-expiration")
    public List<Map<String, Object>> getGoodsNearExpiration() {
        return dashboardService.getGoodsNearExpiration();
    }

    @GetMapping("/most-sold-medicines")
    public List<Map<String, Object>> getMostSoldMedicines() {
        return dashboardService.getMostSoldMedicines();
    }


}
