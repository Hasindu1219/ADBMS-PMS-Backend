package com.pms.PharmacyMS.stockReturn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetInventoryDTO {

    private int inventory_id;
    private String quantity;
    private String received_date;
    private String price;
    private String expiry_date;
    private String medicine_id;
    private String supplier_id;
    private String branch_id;

}
