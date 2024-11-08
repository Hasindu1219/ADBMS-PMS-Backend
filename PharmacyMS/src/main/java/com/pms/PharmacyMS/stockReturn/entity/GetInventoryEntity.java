package com.pms.PharmacyMS.stockReturn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sp_getMedicinesNearToExpiration")
public class GetInventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventory_id;
    private String quantity;
    private String received_date;
    private String price;
    private String expiry_date;
    private String medicine_id;
    private String supplier_id;
    private String branch_id;
    private String medicine_name;


}
