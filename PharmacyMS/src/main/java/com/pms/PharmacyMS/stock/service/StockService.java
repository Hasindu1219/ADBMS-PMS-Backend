package com.pms.PharmacyMS.stock.service;


import com.pms.PharmacyMS.stock.dto.StockViewDTO;
import com.pms.PharmacyMS.stock.entity.StockViewEntity;
import com.pms.PharmacyMS.stock.repository.StockRepo;
import com.pms.PharmacyMS.stock.repository.StockViewRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    private StockViewRepo stockViewRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // get all Stocks
    public List<StockViewEntity> getStockByBranchId(Integer branchId) {
        return stockViewRepo.sales_stock_view(branchId);
    }

    public String updateSalePrice(int medicineId, double newPrice) {
        return stockRepo.sp_UpdateStockSalePrice(medicineId,newPrice);
    }




}
