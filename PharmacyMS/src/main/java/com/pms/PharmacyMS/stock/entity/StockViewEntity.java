package com.pms.PharmacyMS.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "stock_view")
public class StockViewEntity {
    @Id
    private int stock_id;
    private String medicine_name;
    private int stock_quantity;
    private BigDecimal unit_price;
    private String branch_details;
}
