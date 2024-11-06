package com.pms.PharmacyMS.inventory.service;


import com.pms.PharmacyMS.inventory.dto.InventoryDto;
import com.pms.PharmacyMS.inventory.dto.InventoryViewDto;
import com.pms.PharmacyMS.inventory.entity.Inventory;
import com.pms.PharmacyMS.inventory.exception.ResourceNotFoundException;
import com.pms.PharmacyMS.inventory.repository.InventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        //System.out.println("Inventory DTO: " + inventoryDto);
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        //System.out.println("Mapped Inventory Entity: " + inventory);
        inventoryRepo.save(inventory);
        return  inventoryDto;
        
    }
    // get the inventory
    public List<InventoryViewDto> getAllInventoryItems() {
            return inventoryRepo.findAllInventoryView();
    }

    //get the inventory by id
    public InventoryDto getInventoryById(int id) {
        // Fetch the inventory from the database by ID
        Inventory inventory = inventoryRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found"));

        return modelMapper.map(inventory, InventoryDto.class);
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
