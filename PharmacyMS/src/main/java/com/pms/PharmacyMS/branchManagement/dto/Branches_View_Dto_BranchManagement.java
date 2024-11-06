package com.pms.PharmacyMS.branchManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Branches_View_Dto_BranchManagement {
    private int branch_id;
    private String branch_name;
    private String location;
    private String contact_number;
    private String manager_name;
    private String is_disabled;
    private String user_id;
}
