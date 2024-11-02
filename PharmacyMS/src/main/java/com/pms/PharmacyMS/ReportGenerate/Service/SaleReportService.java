package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.SaleDetailsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public List<Object[]> getDailySales(Date selectedDate)
  {
      List<Object[]> dailySales=saleDetailsRepo.getDailySales(selectedDate);
      return  dailySales;
  }

    public List<Object[]> getMonthlySales(Month selectedMonth, Year selectedYear)
    {
        List<Object[]> dailySales=saleDetailsRepo.getMonthlySalesReport(selectedYear,selectedMonth);
        return  dailySales;
    }
}
