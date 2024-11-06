package com.pms.PharmacyMS.branchManagement.repository;

import com.pms.PharmacyMS.branchManagement.entity.Branches_View_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Branches_View_Repo extends JpaRepository<Branches_View_Entity, Integer> {


}
