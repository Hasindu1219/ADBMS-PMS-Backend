package com.pms.PharmacyMS.salesManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sale")
public class SalesEntity_SalesManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bill_no;
    private String sold_date;
    private String branch_id;
}
