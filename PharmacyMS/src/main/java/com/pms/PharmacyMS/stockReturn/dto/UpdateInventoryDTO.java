package com.pms.PharmacyMS.stockReturn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateInventoryDTO {
    private int inventory_archieve_id;
    private String stock_quantity;
    private String medicine_id;
    private String branch_id;
    private String expiry_date;
}
