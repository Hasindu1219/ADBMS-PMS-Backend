package com.pms.PharmacyMS.branchManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int branch_id;
    private String name;
    private String location;
    private String contact_number;
    private String is_disabled;
}
