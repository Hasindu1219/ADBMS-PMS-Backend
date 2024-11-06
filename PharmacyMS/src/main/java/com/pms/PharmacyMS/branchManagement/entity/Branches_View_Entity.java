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
@Table(name = "branches_view")
public class Branches_View_Entity {
    @Id
    private int branch_id;
    private String branch_name;
    private String location;
    private String contact_number;
    private String manager_name;
    private String user_id;
}
