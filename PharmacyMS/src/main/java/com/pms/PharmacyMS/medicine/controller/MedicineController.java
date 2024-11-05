package com.pms.PharmacyMS.medicine.controller;



import com.pms.PharmacyMS.medicine.dto.MedicineDTO;
import com.pms.PharmacyMS.medicine.service.MedicineService;
import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @GetMapping("/getmedicines")
    public List<MedicineDTO> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @PostMapping("/addmedicine")
    public MedicineDTO addMedicine(@RequestBody MedicineDTO medicineDTO) {
        return  medicineService.addMedicine(medicineDTO);
    }

}
