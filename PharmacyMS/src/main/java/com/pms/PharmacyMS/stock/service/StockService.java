package com.pms.PharmacyMS.stock.service;


import com.pms.PharmacyMS.stock.dto.StockViewDTO;
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


    // get all medicines
    public List<StockViewDTO> getAllStocks() {
        return stockViewRepo.findAll().stream()
                .map(stockView -> modelMapper.map(stockView, StockViewDTO.class))
                .collect(Collectors.toList());
    }



//    // delete medicine after checking inventory
//    public String deleteMedicine(int medId) {
//        try {
//            String sql = "{call sp_DeleteMedicine(?)}";
//            jdbcTemplate.update(sql, medId);
//            return "Medicine deleted successfully.";
//        } catch (DataAccessException e) {
//            if (e.getCause() instanceof SQLException) {
//                SQLException sqlException = (SQLException) e.getCause();
//                if ("45000".equals(sqlException.getSQLState())) {
//                    return "Medicine is in inventory and cannot be deleted.";
//                }
//            }
//            return "Error: " + e.getMessage();
//        }
//    }




}
