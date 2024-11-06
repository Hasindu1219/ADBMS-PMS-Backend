package com.pms.PharmacyMS.medicine.controller;



import com.pms.PharmacyMS.medicine.dto.MedicineDTO;
import com.pms.PharmacyMS.medicine.dto.MedicineViewDTO;
import com.pms.PharmacyMS.medicine.service.MedicineService;
import com.pms.PharmacyMS.suppliers.dto.SupplierDto;
import com.pms.PharmacyMS.suppliers.service.SupplierService;
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

    @PostMapping("/addmedicine")
    public MedicineDTO addMedicine(@RequestBody MedicineDTO medicineDTO) {
        return  medicineService.addMedicine(medicineDTO);
    }

    @DeleteMapping("/delete")
    public String deleteMedicine(@RequestParam("medId") int medId) {
        System.out.println("Request to delete medicine with ID: " + medId);
        return medicineService.deleteMedicine(medId);
    }

}
