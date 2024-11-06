package com.pms.PharmacyMS.branchManagement.repository;

import com.pms.PharmacyMS.branchManagement.entity.UserEntity_BranchManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo_BranchManagement extends JpaRepository<UserEntity_BranchManagement,Integer> {

    //Get all not deleted managers
    @Query(nativeQuery = true, value = "select u.* from user u inner join role r on u.role_id=r.role_id  where r.type ='Manager' and u.is_deleted = 0")
    List<UserEntity_BranchManagement> getAllManagers();

}
