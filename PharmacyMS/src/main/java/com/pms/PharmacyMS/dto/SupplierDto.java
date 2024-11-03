package com.pms.PharmacyMS.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    private int supplierId;
    private String supplierName;
    private String address;
    private String phoneNumber;
    private String saleRepName;
    private String email;
}
