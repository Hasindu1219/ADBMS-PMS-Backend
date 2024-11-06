package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.InventoryRepo_RG;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventoryService_RG {
    @Autowired
    private InventoryRepo_RG inventoryRepo;

    public List<Object[]> getPurchaseHistory(int branchId, int month, int year) {
        System.out.println(branchId+month+year);
        return inventoryRepo.getPurchaseHistory(branchId,month,year);
    }
}
