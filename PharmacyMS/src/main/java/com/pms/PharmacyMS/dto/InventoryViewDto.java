package com.pms.PharmacyMS.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryViewDto {


    private Integer quantity;
    private Date receivedDate;
    private BigDecimal price;



}
