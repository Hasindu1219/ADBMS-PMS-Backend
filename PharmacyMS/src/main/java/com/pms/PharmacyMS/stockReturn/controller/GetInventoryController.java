package com.pms.PharmacyMS.stockReturn.controller;



import com.pms.PharmacyMS.stockReturn.dto.GetInventoryDTO;
import com.pms.PharmacyMS.stockReturn.service.GetInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/getInventory")
public class GetInventoryController {
    @Autowired
    private GetInventoryService getInventoryService;

    @GetMapping("/getallInventory/{input_branch_id}")
    public List<GetInventoryDTO> sp_getMedicinesNearToExpiration(@PathVariable String input_branch_id){
        return getInventoryService.sp_getMedicinesNearToExpiration(input_branch_id);
    }

}
