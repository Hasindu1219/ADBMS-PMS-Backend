package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.InventoryRepo;
import com.pms.PharmacyMS.ReportGenerate.Repo.StockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    public List<Object[]> getInventoryForBranch(int branchId) {
        return stockRepo.getInventoryLevel(branchId);
    }

    public List<Object[]> getLowStockItems(int branchId) {
        return stockRepo.getLowStockItems(branchId);
    }

    public List<Object[]>  getExpiryTrackingData(int branchId) {return inventoryRepo.getExpiryTracking(branchId);}
}
