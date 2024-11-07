package com.pms.PharmacyMS.salesManagement.repository;

import com.pms.PharmacyMS.salesManagement.entity.SalesEntity_SalesManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface SalesRepo_SalesManagement extends JpaRepository<SalesEntity_SalesManagement,Integer> {

    //Procedure to store bill in sales
    @Procedure(name = "pay")
    void pay(String InputBranchId);

    //get last bill record
    @Query(nativeQuery = true, value = "select * from sale order by bill_no desc limit 1")
    SalesEntity_SalesManagement getlastBillrecord();
}
