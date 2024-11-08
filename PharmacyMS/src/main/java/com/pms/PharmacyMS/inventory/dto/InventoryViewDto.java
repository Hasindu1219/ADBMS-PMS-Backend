package com.pms.PharmacyMS.inventory.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryViewDto {
    private int inventoryId;
    private int medicineId;
    private int supplierId;  
    private String supplierName;
    private String salesRepName;
    private String phoneNumber;
    private Integer quantity;
    private Date receivedDate;
    private Date expiryDate;
    private BigDecimal price;


}
