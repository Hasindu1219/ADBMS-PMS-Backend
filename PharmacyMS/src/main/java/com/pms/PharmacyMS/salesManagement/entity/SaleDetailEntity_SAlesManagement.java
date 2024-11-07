package com.pms.PharmacyMS.salesManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sale_details")
public class SaleDetailEntity_SAlesManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sale_detail_id;
    private String quantity;
    private String sold_item_unit_price;
    private String bill_no;
    private String medicine_id;
}
