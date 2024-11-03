package com.pms.PharmacyMS.ReportGenerate.Controller;


import com.pms.PharmacyMS.ReportGenerate.Service.SaleReportService;
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

//    http://localhost:8080/api/report/dailySales?selectedDate=2024-11-01
    @GetMapping("/dailySales")
    public List<Object[]> getDailySales(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String selectedDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(selectedDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return saleReportService.getDailySales(date);
    }

//    http://localhost:8080/api/report/monthlySales?selectedMonth=JANUARY&selectedYear=2024
    @GetMapping("/monthlySales")
    public List<Object[]> getMonthlySales(@RequestParam Month selectedMonth, Year selectedYear) {
        return saleReportService.getMonthlySales(selectedMonth,selectedYear);
    }
}
