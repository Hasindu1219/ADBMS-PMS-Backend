package com.pms.PharmacyMS.salesManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDetailsDto_SalesManagement {

    private int sale_detail_id;
    private String quantity;
    private String sold_item_unit_price;
    private String bill_no;
    private String medicine_id;
}
