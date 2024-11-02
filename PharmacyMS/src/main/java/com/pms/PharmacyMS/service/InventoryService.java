package com.pms.PharmacyMS.service;

import com.pms.PharmacyMS.dto.InventoryDto;
import com.pms.PharmacyMS.dto.InventoryViewDto;
import com.pms.PharmacyMS.model.Inventory;
import com.pms.PharmacyMS.repository.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Save the inventory record
    public InventoryDto addInventory(InventoryDto inventoryDto) {
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        inventoryRepo.save(inventory);
        //inventoryRepo.save(modelMapper.map(inventoryDto, Inventory.class));

        // Update stock quantity based on medicineId
        inventoryRepo.updateStockQuantity(inventoryDto.getQuantity(),inventoryDto.getMedicineId());
        return  inventoryDto;
    }

    public List<InventoryViewDto> getAllInventoryItems() {
            return inventoryRepo.findAllInventoryView();
    }
}
