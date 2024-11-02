package com.pms.PharmacyMS.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="stock")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Stock {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="stock_id")
    private int stokId;
    private int medicineId;
    private int stockQuantity;
    private BigDecimal unitPrice;
    private int branchId;

}
