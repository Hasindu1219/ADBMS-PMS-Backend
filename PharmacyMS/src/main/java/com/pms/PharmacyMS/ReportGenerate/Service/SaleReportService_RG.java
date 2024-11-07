package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.SaleDetailsRepo_RG;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SaleReportService_RG
{
    @Autowired
    private SaleDetailsRepo_RG saleDetailsRepo;


    public List<Object[]> getMonthlySales(int selectedMonth,int selectedYear) {
        return saleDetailsRepo.getMonthlySales(selectedMonth, selectedYear);
    }
    public List<Object[]> getDailySales(Date selectedDate,int branchID) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        return saleDetailsRepo.getBranchDailySales(formattedDate,branchID);
    }

    public List<Object[]> getDailySales(Date selectedDate) {
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate);
        return saleDetailsRepo.getDailySales(formattedDate);
    }

    public List<Object[]> getYearlySales(String year) {
        return saleDetailsRepo.getYearlySales(Integer.parseInt(year));
    }

    public List<Object[]> getTodaySales(String option)
    {
        List<Object[]> sales=new ArrayList<>();
    if(option.equals("Daily"))
        sales= saleDetailsRepo.getTodaySales();
    else if(option.equals("Monthly"))
        sales=saleDetailsRepo.getThisMonthSales();
    else if (option.equals("Yearly")) {
        sales=saleDetailsRepo.getThisYearSales();
    }
    return sales;
    }



}
