package com.pms.PharmacyMS.medicine.repository;


import com.pms.PharmacyMS.medicine.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepo extends JpaRepository<MedicineEntity,Integer>{

}
