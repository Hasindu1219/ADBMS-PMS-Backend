package com.pms.PharmacyMS.ReportGenerate.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    private int inventory_id;
    private int quantity;
    private Date received_date;
    private Date expiry_date;
    private  int medicine_id;
    private int supplier_id;
    private int branch_id;
}
