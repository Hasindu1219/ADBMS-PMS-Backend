package com.pms.PharmacyMS.Management_DU.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetails {
    private String name;
    private String contact_no;
    private float salary;
    private Year joined_date;
    private String email;
    private int branch_id;
    private int role_id;
}
