package com.pms.PharmacyMS.Management_DU.Repository;


import com.pms.PharmacyMS.Management_DU.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    @Query(nativeQuery = true,value = "select * from user where is_deleted=0 and email=:email")
    UserEntity findByEmail(@Param("email") String email);
}
