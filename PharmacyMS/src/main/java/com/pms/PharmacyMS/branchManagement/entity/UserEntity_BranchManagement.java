package com.pms.PharmacyMS.branchManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity_BranchManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    private String contact_no;
    private float salary;
    private String joined_date;
    private String email;
    private String password;
    private int branch_id;
    private int role_id;
    private int is_deleted;
}
