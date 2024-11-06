package com.pms.PharmacyMS.medicine.service;


import com.pms.PharmacyMS.medicine.dto.MedicineDTO;
import com.pms.PharmacyMS.medicine.dto.MedicineViewDTO;
import com.pms.PharmacyMS.medicine.entity.MedicineEntity;
import com.pms.PharmacyMS.medicine.entity.MedicineViewEntity;
import com.pms.PharmacyMS.medicine.repository.MedicineRepo;
import com.pms.PharmacyMS.medicine.repository.MedicineViewRepo;
import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.entity.Supplier;
import com.pms.PharmacyMS.suppliers.repository.SupplierRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    @Autowired
    private MedicineViewRepo medicineViewRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // get all medicines
    public List<MedicineViewDTO> getAllMedicines() {
        return medicineViewRepo.findAll().stream()
                .map(medicineView -> modelMapper.map(medicineView, MedicineViewDTO.class))
                .collect(Collectors.toList());
    }

    // add medicine
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {
        medicineRepo.save(modelMapper.map( medicineDTO, MedicineEntity.class));
        return  medicineDTO;
    }


    public String deleteMedicine(int medId) {
        try {
            String sql = "{call sp_DeleteMedicine(?)}";
            jdbcTemplate.update(sql, medId);
            return "Medicine deleted successfully.";
        } catch (DataAccessException e) {
            if (e.getCause() instanceof SQLException) {
                SQLException sqlException = (SQLException) e.getCause();
                if ("45000".equals(sqlException.getSQLState())) {
                    return "Medicine is in inventory and cannot be deleted.";
                }
            }
            return "Error: " + e.getMessage();
        }
    }

}
