package com.pms.PharmacyMS.branchManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "branch")
public class BranchEntity_BranchManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branch_id;
    private String name;
    private String location;
    private String contact_number;
    private String is_disabled;
}
