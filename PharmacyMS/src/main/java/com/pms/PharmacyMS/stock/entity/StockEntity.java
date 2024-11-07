package com.pms.PharmacyMS.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stock_id;
    private int medicine_id;
    private int stock_quantity;
    private BigDecimal unit_price;
    private int branch_id;

}
