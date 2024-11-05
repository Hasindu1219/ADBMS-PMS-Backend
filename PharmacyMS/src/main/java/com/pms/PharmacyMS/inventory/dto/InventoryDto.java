package com.pms.PharmacyMS.inventory.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private int inventoryId;
    private Integer quantity;
    private Date receivedDate;
    private BigDecimal price;
    private int supplierId;
    private int medicineId;
    private Date expiryDate;

}
