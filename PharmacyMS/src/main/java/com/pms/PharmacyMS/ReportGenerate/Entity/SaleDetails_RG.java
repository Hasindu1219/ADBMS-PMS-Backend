package com.pms.PharmacyMS.ReportGenerate.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SaleDetails_RG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sale_detail_id;
    private int quantity;
    private double sold_item_unit_price;
    private int bill_no;

    private int medicine_id;
}
