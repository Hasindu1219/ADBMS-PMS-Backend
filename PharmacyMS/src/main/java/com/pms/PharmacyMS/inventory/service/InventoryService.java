package com.pms.PharmacyMS.inventory.service;


import com.pms.PharmacyMS.inventory.dto.InventoryDto;
import com.pms.PharmacyMS.inventory.dto.InventoryViewDto;
import com.pms.PharmacyMS.inventory.entity.Inventory;
import com.pms.PharmacyMS.inventory.exception.ResourceNotFoundException;
import com.pms.PharmacyMS.inventory.repository.InventoryRepo;
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
        return  inventoryDto;
        
    }
    // get the inventory
    public List<InventoryViewDto> getAllInventoryItems() {
            return inventoryRepo.findAllInventoryView();
    }

    // Update inventory
    public InventoryDto updateInventory(int id, InventoryDto inventoryDto) {
        Inventory inventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id: " + id));

        // Map updated fields from DTO to the entity
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setReceivedDate(inventoryDto.getReceivedDate());
        inventory.setPrice(inventoryDto.getPrice());
        inventory.setSupplierId(inventoryDto.getSupplierId());
        inventory.setMedicineId(inventoryDto.getMedicineId());
        inventory.setExpiryDate(inventoryDto.getExpiryDate());

        inventoryRepo.save(inventory);
        return inventoryDto;
    }
}
