package com.pms.PharmacyMS.Management_Medicine.Repository;


import com.pms.PharmacyMS.Management_Medicine.Entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepo extends JpaRepository<MedicineEntity,Integer>{

}
