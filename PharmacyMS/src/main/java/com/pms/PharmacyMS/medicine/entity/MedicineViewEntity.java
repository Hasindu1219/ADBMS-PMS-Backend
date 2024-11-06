package com.pms.PharmacyMS.medicine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "medicine_view")
public class MedicineViewEntity {
    @Id
    private int medicine_id;
    private String medicine_name;
    private String supplier_details;
    private String unit_type;
    private float dose;
}
