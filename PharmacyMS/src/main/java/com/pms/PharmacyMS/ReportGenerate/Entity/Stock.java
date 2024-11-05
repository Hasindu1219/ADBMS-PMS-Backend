package com.pms.PharmacyMS.ReportGenerate.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_id;

    private int medicine_id;

    private int stock_quantity;

    private double unit_price;

    private int branch_id;

}
