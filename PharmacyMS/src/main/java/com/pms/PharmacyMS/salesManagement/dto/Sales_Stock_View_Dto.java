package com.pms.PharmacyMS.salesManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sales_Stock_View_Dto {
    private int stock_id;
    private String medicine_id;
    private int stock_quantity;
    private String unit_price;
    private String branch_id;
    private String medicine_name;
    private String unit_type;
    private String dose;
}
