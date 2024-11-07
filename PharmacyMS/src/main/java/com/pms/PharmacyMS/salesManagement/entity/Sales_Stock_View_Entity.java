package com.pms.PharmacyMS.salesManagement.entity;

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
@Table(name = "sales_stock_view")
public class Sales_Stock_View_Entity {
    @Id
    private int stock_id;
    private String medicine_id;
    private int stock_quantity;
    private String unit_price;
    private String branch_id;
    private String medicine_name;
    private String unit_type;
    private String dose;
}
