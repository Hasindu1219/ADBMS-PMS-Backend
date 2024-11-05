package com.pms.PharmacyMS.inventory.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="inventory")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private int inventoryId;

    private Integer quantity;

    @Column(name="received_date")
    private Date receivedDate;

    private BigDecimal price;

    @Column(name="medicine_id")
    private int medicineId;


    @Column(name="supplier_id")
    private int supplierId;


}
