package com.pms.PharmacyMS.salesManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesDto_SalesManagement {

    private int bill_no;
    private String sold_date;
    private String branch_id;
}
