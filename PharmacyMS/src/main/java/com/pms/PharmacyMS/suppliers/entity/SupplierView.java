package com.pms.PharmacyMS.suppliers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="`supplier_view`")
@Data
public class SupplierView {
    @Id
    private int supplierId;
    private String supplierName;
    private String saleRepName;
    private String address;
    private String phoneNumber;
    private String email;
}
