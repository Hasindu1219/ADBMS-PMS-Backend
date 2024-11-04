package com.pms.PharmacyMS.Management_Medicine.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicineDTO {

    private int medicine_id;
    private String medicine_name;
    private int brand_id;
    private String unit_type;
    private float dose;
}
