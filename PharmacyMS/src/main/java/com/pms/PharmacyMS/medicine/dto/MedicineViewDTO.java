package com.pms.PharmacyMS.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineViewDTO {

    private int medicine_id;
    private String medicine_name;
    private String supplier_details;
    private String unit_type;
    private float dose;
}
