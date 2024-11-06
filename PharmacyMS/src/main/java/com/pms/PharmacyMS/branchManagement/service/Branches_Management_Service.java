package com.pms.PharmacyMS.branchManagement.service;

import com.pms.PharmacyMS.branchManagement.dto.Branches_View_Dto;
import com.pms.PharmacyMS.branchManagement.entity.Branches_View_Entity;
import com.pms.PharmacyMS.branchManagement.repository.BranchRepo;
import com.pms.PharmacyMS.branchManagement.repository.Branches_View_Repo;
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
    private Branches_View_Repo branchesViewRepo;
    @Autowired
    private BranchRepo branchRepo;
    @Autowired
    private ModelMapper modelMapper;



    // -------------------------------- Service for Branches_view -------------------START

    //Get all from barnch_view
    public List<Branches_View_Dto> getAllBranches (){
        List<Branches_View_Entity> allBranches = branchesViewRepo.findAll();
        return modelMapper.map(allBranches, new TypeToken <ArrayList<Branches_View_Dto>>(){}.getType());
    }

    // -------------------------------- Service for Branches_view -------------------END








    // -------------------------------- Service for Branches TABLE -------------------START

    //Update disable status of branches
    public void updateIsDisabled(String branch_id,String is_disabled ){
        branchRepo.updateIsDisabled(branch_id,is_disabled);
    }


    // -------------------------------- Service for Branches TABLE -------------------END
}
