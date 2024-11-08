package com.pms.PharmacyMS.stockReturn.repository;


import com.pms.PharmacyMS.stockReturn.entity.GetInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GetInventoryRepo extends JpaRepository<GetInventoryEntity,Integer> {

    @Procedure(name = "sp_getMedicinesNearToExpiration")
    List<GetInventoryEntity> sp_getMedicinesNearToExpiration(String input_branch_id);


}
