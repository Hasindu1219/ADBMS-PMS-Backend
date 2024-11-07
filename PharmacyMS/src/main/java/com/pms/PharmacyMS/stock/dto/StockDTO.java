package com.pms.PharmacyMS.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDTO {

    private int stock_id;
    private int medicine_id;
    private int stock_quantity;
    private BigDecimal unit_price;
    private int branch_id;

}
