package com.pms.PharmacyMS.branchManagement.controllor;

import com.pms.PharmacyMS.branchManagement.dto.Branches_View_Dto;
import com.pms.PharmacyMS.branchManagement.service.Branches_Management_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/branchManagement")
public class Branch_Management_Controller {
    @Autowired
    private Branches_Management_Service branchesManagementService;



    //Api to get all branches through a view
    @GetMapping("/getAllBranches")
    public List<Branches_View_Dto> getAllBranches(){
        return branchesManagementService.getAllBranches();
    }
}
