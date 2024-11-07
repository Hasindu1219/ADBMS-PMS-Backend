package com.pms.PharmacyMS.salesManagement.service;

import com.pms.PharmacyMS.salesManagement.dto.Sales_Stock_View_Dto;
import com.pms.PharmacyMS.salesManagement.entity.Sales_Stock_View_Entity;
import com.pms.PharmacyMS.salesManagement.repository.Sales_Stock_View_Repo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SAlesManagementService {
    @Autowired
    private Sales_Stock_View_Repo sales_Stock_View_Repo;
    @Autowired
    private ModelMapper modelMapper;



    // -------------------- Service for Sales_Stock_view-------------------START

    //Get all from service_stock_view
    public List<Sales_Stock_View_Dto> sales_stock_view(String inputBranchId){
        List<Sales_Stock_View_Entity> result = sales_Stock_View_Repo.sales_stock_view(inputBranchId);
        return modelMapper.map(result,new TypeToken<ArrayList<Sales_Stock_View_Dto>>(){}.getType());
    }


    // -------------------- Service for Sales_Stock_view-------------------END


}
