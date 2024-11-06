package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.InventoryRepo_RG;
import com.pms.PharmacyMS.ReportGenerate.Repo.StockRepo_RG;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockService_RG {

    @Autowired
    private StockRepo_RG stockRepo;

    @Autowired
    private InventoryRepo_RG inventoryRepo;

    public List<Object[]> getInventoryForBranch(int branchId) {
        return stockRepo.getInventoryLevel(branchId);
    }

    public List<Object[]> getLowStockItems(int branchId) {
        return stockRepo.getLowStockItems(branchId);
    }

    public List<Object[]>  getExpiryTrackingData(int branchId) {return inventoryRepo.getExpiryTracking(branchId);}
}
