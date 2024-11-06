package com.pms.PharmacyMS.branchManagement.controller;

import com.pms.PharmacyMS.branchManagement.dto.BranchDto_BranchManagement;
import com.pms.PharmacyMS.branchManagement.dto.Branches_View_Dto_BranchManagement;
import com.pms.PharmacyMS.branchManagement.dto.UserDto_branchManagement;
import com.pms.PharmacyMS.branchManagement.service.Branches_Management_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/branchManagement")
public class Branch_Management_Controller {
    @Autowired
    private Branches_Management_Service branchesManagementService;


    //-----------------------------------------------Controller for branch_view ------------------ START

    //Api to get all branches through a view
    @GetMapping("/getAllBranches")
    public List<Branches_View_Dto_BranchManagement> getAllBranches() {
        return branchesManagementService.getAllBranches();
    }

    //-----------------------------------------------Controller for branch_view ------------------ END


    //-----------------------------------------------Controller for branch table ------------------ START

    //update enable disable status of branch
    @PostMapping("/updateIsDisabled")
    public void updateIsDisabled(@RequestBody BranchDto_BranchManagement branchDto) {
        branchesManagementService.updateIsDisabled(String.valueOf(branchDto.getBranch_id()), branchDto.getIs_disabled());
    }

    //Update branch
//    @PutMapping("/procedure_update_branch/{inputBranchID}/{inputName}/{inputLocation}/{inputContactNumber}/{inputUserId}")
    @PutMapping("/procedure_update_branch")
    public void procedure_update_branch(@RequestBody Branches_View_Dto_BranchManagement branchDto) {
        System.out.println("Location is "+ branchDto.getLocation());
        branchesManagementService.procedure_update_branch(
                String.valueOf(branchDto.getBranch_id()),
                branchDto.getBranch_name(),
                branchDto.getLocation(),
                branchDto.getContact_number(),
                branchDto.getUser_id());
    }


    @PostMapping("/procedure_insert_branch")
    public void procedure_insert_branch(@RequestBody Branches_View_Dto_BranchManagement branchDto) {
        branchesManagementService.procedure_insert_branch(
                branchDto.getBranch_name(),
                branchDto.getLocation(),
                branchDto.getContact_number()
        );
    }


    //-----------------------------------------------Controller for branch table ------------------ END




    //-----------------------------------------------Controller for user table ------------------ START
    @GetMapping ("/getAllManagers")
    public List<UserDto_branchManagement> getAllManagers(){
        return branchesManagementService.getAllManagers();
    }

    //-----------------------------------------------Controller for user table ------------------ END
}
