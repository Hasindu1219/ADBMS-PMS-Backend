package com.pms.PharmacyMS.controller;

import com.pms.PharmacyMS.dto.InventoryDto;
import com.pms.PharmacyMS.dto.InventoryViewDto;
import com.pms.PharmacyMS.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/v1")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/addinventory")
    public InventoryDto addInventory(@RequestBody InventoryDto inventoryDto) {
        return  inventoryService.addInventory(inventoryDto);
    }

    @GetMapping("/inventoryview")
    public List<InventoryViewDto> getInventoryView(){
        return inventoryService.getAllInventoryItems();
    }
}
