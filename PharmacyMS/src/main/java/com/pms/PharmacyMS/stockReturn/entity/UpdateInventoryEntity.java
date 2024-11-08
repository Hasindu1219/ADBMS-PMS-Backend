package com.pms.PharmacyMS.stockReturn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sp_addMedicineArchieve")
public class UpdateInventoryEntity {
     @Id
     private int inventory_archieve_id;
     private String stock_quantity;
     private String medicine_id;
     private String branch_id;
     private String expiry_date;
}
