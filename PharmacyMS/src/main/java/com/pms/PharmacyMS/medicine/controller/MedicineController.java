package com.pms.PharmacyMS.medicine.controller;



import com.pms.PharmacyMS.branchManagement.dto.Branches_View_Dto_BranchManagement;
import com.pms.PharmacyMS.medicine.dto.MedicineDTO;
import com.pms.PharmacyMS.medicine.dto.MedicineViewDTO;
import com.pms.PharmacyMS.medicine.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping("/getallmedicines")
    public List<MedicineViewDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

//    @PostMapping("/addmedicine")
//    public MedicineDTO addMedicine(@RequestBody MedicineDTO medicineDTO) {
//        return  medicineService.addMedicine(medicineDTO);
//    }

    @DeleteMapping("/delete")
    public String deleteMedicine(@RequestParam("medId") int medId) {
        System.out.println("Request to delete medicine with ID: " + medId);
        return medicineService.deleteMedicine(medId);
    }

//    //Update medicine
//    @PutMapping("/procedure_update_branch")
//    public void procedure_update_branch(@RequestBody Branches_View_Dto_BranchManagement branchDto) {
//        System.out.println("Location is "+ branchDto.getLocation());
//        branchesManagementService.procedure_update_branch(
//                String.valueOf(branchDto.getBranch_id()),
//                branchDto.getBranch_name(),
//                branchDto.getLocation(),
//                branchDto.getContact_number(),
//                branchDto.getUser_id());
//    }


    @PostMapping("/add")
    public void procedure_insert_medicine(@RequestBody MedicineDTO medicineDTO) {
        System.out.println(medicineDTO);
        medicineService.sp_AddMedicine(
                medicineDTO.getMedicine_name(),
                medicineDTO.getSupplier_id(),
                medicineDTO.getUnit_type(),
                medicineDTO.getDose()
        );
    }

}
