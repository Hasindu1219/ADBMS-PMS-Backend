package com.pms.PharmacyMS.Management_DU.Repository;


import com.pms.PharmacyMS.Management_DU.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    @Query(nativeQuery = true,value = "select * from user where is_deleted=0 and email=:email")
    UserEntity findByEmail(@Param("email") String email);

    @Procedure(procedureName = "CreateUser")
    void createUser(
            @Param("p_name") String name,
            @Param("p_contact_no") String contactNo,
            @Param("p_salary") Float salary,
            @Param("p_joined_date") String joinedDate,
            @Param("p_email") String email,
            @Param("p_password") String password,
            @Param("p_branch_id") Integer branchId,
            @Param("p_role_id") Integer roleId
    );

    @Procedure(procedureName = "GetUserById")
    UserEntity getUserById(@Param("p_user_id") Integer userId);

    @Procedure(procedureName = "UpdateUser")
    void updateUser(
            @Param("p_user_id") Integer userId,
            @Param("p_name") String name,
            @Param("p_contact_no") String contactNo,
            @Param("p_salary") Float salary,
            @Param("p_joined_date") String joinedDate,
            @Param("p_email") String email,
            @Param("p_password") String password,
            @Param("p_branch_id") Integer branchId,
            @Param("p_role_id") Integer roleId
    );

    @Procedure(procedureName = "SoftDeleteUser")
    void softDeleteUser(@Param("p_user_id") Integer userId);


    @Procedure(procedureName = "GetAllActiveUsers")
    List<UserEntity> getAllActiveUsers();

    //GetAllDisabledUsers
    @Procedure(procedureName = "GetAllDisabledUsers")
    List<UserEntity> getAllDisabledUsers();
}
