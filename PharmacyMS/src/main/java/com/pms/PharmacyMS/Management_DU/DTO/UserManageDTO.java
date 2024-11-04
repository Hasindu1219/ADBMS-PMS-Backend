package com.pms.PharmacyMS.Management_DU.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserManageDTO {
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
