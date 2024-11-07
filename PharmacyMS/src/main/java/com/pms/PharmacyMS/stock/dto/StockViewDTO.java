package com.pms.PharmacyMS.stock.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockViewDTO {

    private int stock_id;
    private String medicine_name;
    private String unit_type;
    private String dose;
    private int stock_quantity;
    private BigDecimal unit_price;
}
