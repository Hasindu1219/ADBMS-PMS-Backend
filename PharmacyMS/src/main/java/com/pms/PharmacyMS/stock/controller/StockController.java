package com.pms.PharmacyMS.stock.controller;



import com.pms.PharmacyMS.stock.dto.StockDTO;
import com.pms.PharmacyMS.stock.dto.StockViewDTO;
import com.pms.PharmacyMS.stock.entity.StockViewEntity;
import com.pms.PharmacyMS.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    // Endpoint for get all stock details
    @GetMapping("/getstocksinbranch/{branchId}")
    public List<StockViewEntity> getStockByBranch(@PathVariable Integer branchId) {
        return stockService.getStockByBranchId(branchId);
    }


    // Endpoint to update stock sale price
    @PutMapping("/updatesaleprice")
    public String updatePrice(@RequestParam int medicineId, @RequestParam double newPrice) {
        return stockService.updateSalePrice(medicineId,newPrice);
    }

}
