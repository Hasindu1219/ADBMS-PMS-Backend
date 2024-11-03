package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.SaleDetailsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SaleReportService
{
    @Autowired
    private SaleDetailsRepo saleDetailsRepo;


    public List<Object[]> getMonthlySales(Month selectedMonth, Year selectedYear)
    {
        List<Object[]> dailySales=saleDetailsRepo.getMonthlySalesReport(selectedYear,selectedMonth);
        return  dailySales;
    }
    public List<Object[]> getDailySales(Date selectedDate) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        return saleDetailsRepo.getDailySales(formattedDate);
    }

}
