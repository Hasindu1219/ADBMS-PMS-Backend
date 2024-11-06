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


    //Procedure to update medicine
    @Procedure(name = "sp_UpdateMedicine")
    void sp_UpdateMedicine(int med_id, String med_name, int sup_id, String u_type,float Dose);


    //Procedure to insert a medicine
    @Procedure (name = "sp_AddMedicine")
    void sp_AddMedicine(String med_name, int sup_id, String u_type,float Dose );

}
