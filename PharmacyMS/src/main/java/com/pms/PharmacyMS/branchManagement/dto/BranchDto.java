package com.pms.PharmacyMS.branchManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {
    private int branch_id;
    private String name;
    private String location;
    private String contact_number;
    private String is_disabled;
}
