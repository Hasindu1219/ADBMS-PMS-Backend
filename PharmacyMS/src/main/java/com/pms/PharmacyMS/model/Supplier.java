package com.pms.PharmacyMS.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="supplier")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplier_id")
    private int supplierId;
    @Column(name="supplier_name")
    private String supplierName;
    @Column(name="sale_rep_name")
    private String saleRepName;
    private String address;
    @Column(name="phone_number")
    private String phoneNumber;
    private String email;

}
