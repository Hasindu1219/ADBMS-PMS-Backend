package com.pms.PharmacyMS.branchManagement.repository;

import com.pms.PharmacyMS.branchManagement.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<BranchEntity,Integer> {
}
