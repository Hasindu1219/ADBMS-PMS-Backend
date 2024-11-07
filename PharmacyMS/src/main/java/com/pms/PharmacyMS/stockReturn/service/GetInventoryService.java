package com.pms.PharmacyMS.stockReturn.service;


import com.pms.PharmacyMS.stockReturn.dto.GetInventoryDTO;
import com.pms.PharmacyMS.stockReturn.entity.GetInventoryEntity;
import com.pms.PharmacyMS.stockReturn.repository.GetInventoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GetInventoryService {

    @Autowired
    private GetInventoryRepo getInventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<GetInventoryDTO> sp_getMedicinesNearToExpiration(String input_branch_id){
        List<GetInventoryEntity> result = getInventoryRepo.sp_getMedicinesNearToExpiration(input_branch_id);
        return modelMapper.map(result,new TypeToken<ArrayList<GetInventoryDTO>>(){}.getType());
    }



}
