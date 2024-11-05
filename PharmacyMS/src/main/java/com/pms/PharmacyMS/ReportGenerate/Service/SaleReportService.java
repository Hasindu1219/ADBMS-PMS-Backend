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


    public List<Object[]> getMonthlySales(Month selectedMonth,Year selectedYear) {
        String yearStr = String.valueOf(selectedYear.getValue());
        String monthStr = String.format("%02d", selectedMonth.getValue());
        return saleDetailsRepo.getMonthlySalesReport(yearStr, monthStr);
    }
    public List<Object[]> getDailySales(Date selectedDate,int branchID) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        return saleDetailsRepo.getBranchDailySales(formattedDate,branchID);
    }

}
