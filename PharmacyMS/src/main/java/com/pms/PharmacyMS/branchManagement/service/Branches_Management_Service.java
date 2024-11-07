package com.pms.PharmacyMS.branchManagement.service;

import com.pms.PharmacyMS.branchManagement.dto.Branches_View_Dto_BranchManagement;
import com.pms.PharmacyMS.branchManagement.dto.UserDto_branchManagement;
import com.pms.PharmacyMS.branchManagement.entity.Branches_View_Entity_BranchManagement;
import com.pms.PharmacyMS.branchManagement.entity.UserEntity_BranchManagement;
import com.pms.PharmacyMS.branchManagement.repository.BranchRepo_BranchManagement;
import com.pms.PharmacyMS.branchManagement.repository.Branches_View_Repo_BranchManagement;
import com.pms.PharmacyMS.branchManagement.repository.UserRepo_BranchManagement;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Branches_Management_Service {

    @Autowired
    private Branches_View_Repo_BranchManagement branchesViewRepo;
    @Autowired
    private BranchRepo_BranchManagement branchRepo;
    @Autowired
    private UserRepo_BranchManagement userRepoBranchManagement;
    @Autowired
    private ModelMapper modelMapper;



    // -------------------------------- Service for Branches_view -------------------START

    //Get all from barnch_view
    public List<Branches_View_Dto_BranchManagement> getAllBranches (){
        List<Branches_View_Entity_BranchManagement> allBranches = branchesViewRepo.findAll();
        return modelMapper.map(allBranches, new TypeToken <ArrayList<Branches_View_Dto_BranchManagement>>(){}.getType());
    }

    // -------------------------------- Service for Branches_view -------------------END






    // -------------------------------- Service for Branches TABLE -------------------START

    //Update disable status of branches
    public void updateIsDisabled(String branch_id,String is_disabled ){
        branchRepo.updateIsDisabled(branch_id,is_disabled);
    }

    //Update branch
    public void procedure_update_branch (String inputBranchID, String inputName, String inputLocation, String inputContactNumber, String inputUserId){
        branchRepo.procedure_update_branch( inputBranchID, inputName, inputLocation, inputContactNumber, inputUserId );
    }


    //Insert Branch
    public void procedure_insert_branch (String inputName, String inputLocation, String inputContactNumber){
        branchRepo.procedure_insert_branch(inputName, inputLocation, inputContactNumber);
    }


    // -------------------------------- Service for Branches TABLE -------------------END



    // -------------------------------- Service for User TABLE -------------------START
    public List<UserDto_branchManagement> getAllManagers(){
        List<UserEntity_BranchManagement> useList = userRepoBranchManagement.getAllManagers();
        return modelMapper.map(useList, new TypeToken <ArrayList<UserDto_branchManagement>>(){}.getType());
    }

    // -------------------------------- Service for User TABLE -------------------END




}
