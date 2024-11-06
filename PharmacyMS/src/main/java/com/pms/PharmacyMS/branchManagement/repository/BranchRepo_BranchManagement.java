package com.pms.PharmacyMS.branchManagement.repository;

import com.pms.PharmacyMS.branchManagement.entity.BranchEntity_BranchManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepo_BranchManagement extends JpaRepository<BranchEntity_BranchManagement,Integer> {

    //Update is_disable status
    @Modifying
    @Query(nativeQuery = true, value = "update branch set is_disabled = :is_disabled where branch_id = :branch_id")
    void updateIsDisabled(String branch_id,String is_disabled);

}
