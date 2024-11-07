package com.pms.PharmacyMS.medicine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDTO {

    private int medicine_id;
    private String medicine_name;
    private int supplier_id;
    private String unit_type;
    private float dose;

}
