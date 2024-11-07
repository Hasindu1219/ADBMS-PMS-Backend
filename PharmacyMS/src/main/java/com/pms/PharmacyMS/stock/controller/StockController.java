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

    @GetMapping("/getstocksinbranch/{branchId}")
    public List<StockViewEntity> getStockByBranch(@PathVariable Integer branchId) {
        return stockService.getStockByBranchId(branchId);
    }



//    //Delete medicine
//    @DeleteMapping("/delete")
//    public String deleteMedicine(@RequestParam("medId") int medId) {
//        System.out.println("Request to delete medicine with ID: " + medId);
//        return medicineService.deleteMedicine(medId);
//    }



}
