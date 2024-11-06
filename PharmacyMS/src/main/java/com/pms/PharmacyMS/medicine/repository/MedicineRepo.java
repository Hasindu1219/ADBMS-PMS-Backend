package com.pms.PharmacyMS.medicine.repository;


import com.pms.PharmacyMS.medicine.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicineRepo extends JpaRepository<MedicineEntity,Integer> {
    @Transactional
    @Procedure(name = "sp_DeleteMedicine")
    String deleteMedicine(@Param("medId") Long medId);

}