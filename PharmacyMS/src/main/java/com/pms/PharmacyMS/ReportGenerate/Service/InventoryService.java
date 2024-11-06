package com.pms.PharmacyMS.ReportGenerate.Service;

import com.pms.PharmacyMS.ReportGenerate.Repo.InventoryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    public List<Object[]> getPurchaseHistory(int branchId, int month, int year) {
        System.out.println(branchId+month+year);
        return inventoryRepo.getPurchaseHistory(branchId,month,year);
    }
}
