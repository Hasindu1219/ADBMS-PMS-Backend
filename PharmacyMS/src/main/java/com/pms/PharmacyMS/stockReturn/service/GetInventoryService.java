package com.pms.PharmacyMS.stockReturn.service;


import com.pms.PharmacyMS.stockReturn.dto.GetInventoryDTO;
import com.pms.PharmacyMS.stockReturn.entity.GetInventoryEntity;
import com.pms.PharmacyMS.stockReturn.repository.GetInventoryRepo;
import com.pms.PharmacyMS.stockReturn.repository.UpdateInventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GetInventoryService {

    @Autowired
    private GetInventoryRepo getInventoryRepo;

    @Autowired
    private UpdateInventoryRepo updateInventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<GetInventoryDTO> sp_getMedicinesNearToExpiration(String input_branch_id){
        List<GetInventoryEntity> result = getInventoryRepo.sp_getMedicinesNearToExpiration(input_branch_id);
        return modelMapper.map(result,new TypeToken<ArrayList<GetInventoryDTO>>(){}.getType());
    }

    public void addToStockArchive(int stockQuantity, int medicineId, int branchId, String expiryDate) {
        // Convert String expiryDate to Timestamp
        Timestamp timestamp = Timestamp.valueOf(expiryDate);

        // Call the stored procedure via the repository
        updateInventoryRepo.sp_AddToStockArchive(stockQuantity, medicineId, branchId, timestamp);
    }


}
