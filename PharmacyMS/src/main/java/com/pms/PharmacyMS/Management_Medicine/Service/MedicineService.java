package com.pms.PharmacyMS.Management_Medicine.Service;

import com.pms.PharmacyMS.Management_Medicine.DTO.MedicineDTO;
import com.pms.PharmacyMS.Management_Medicine.DTO.ResponseDTO;
import com.pms.PharmacyMS.Management_Medicine.Util.VarList;
import com.pms.PharmacyMS.Management_Medicine.Entity.MedicineEntity;
import com.pms.PharmacyMS.Management_Medicine.Repository.MedicineRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;

    @Autowired
    private ResponseDTO responseDTO;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseDTO getAllMedicines(){
        List<MedicineEntity> medicineEntities = medicineRepo.findAll();
        if (medicineEntities.isEmpty()){
            responseDTO.setCode(VarList.RIP_NO_DATA_FOUND);
            responseDTO.setContent(null);
            responseDTO.setMessage("Medicines not found!");
        }else {
            responseDTO.setCode(VarList.RIP_SUCCESS);
            responseDTO.setContent(modelMapper.map(medicineEntities, new TypeToken<ArrayList<MedicineDTO>>(){}.getType()));
            responseDTO.setMessage("Medicines found!");
        }
        return responseDTO;
    }


}
