package com.pms.PharmacyMS.medicine.repository;

import com.pms.PharmacyMS.medicine.entity.MedicineViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineViewRepo extends JpaRepository<MedicineViewEntity,Integer> {
}
