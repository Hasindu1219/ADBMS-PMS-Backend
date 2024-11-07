package com.pms.PharmacyMS.salesManagement.controller;

import com.pms.PharmacyMS.salesManagement.dto.Sales_Stock_View_Dto;
import com.pms.PharmacyMS.salesManagement.service.SAlesManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/salesManagement")
public class SalesManagementController {

    @Autowired
    private SAlesManagementService salesManagementService;

    // ---------------------controller for sales_management_view procedure --------------START

    //API to get the stock details to sale component
    @GetMapping ("/sales_stock_view/{inputBranchId}")
    public List<Sales_Stock_View_Dto> sales_stock_view(@PathVariable String inputBranchId) {
        return salesManagementService.sales_stock_view(inputBranchId);
    }

    // ---------------------controller for sales_management_view procedure --------------END

}
