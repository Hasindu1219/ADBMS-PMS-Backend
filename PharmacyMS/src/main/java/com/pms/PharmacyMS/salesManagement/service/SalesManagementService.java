package com.pms.PharmacyMS.salesManagement.service;

import com.pms.PharmacyMS.salesManagement.dto.SaleDetailsDto_SalesManagement;
import com.pms.PharmacyMS.salesManagement.entity.SaleDetailEntity_SAlesManagement;
import com.pms.PharmacyMS.salesManagement.repository.SaleDetailRepo_SalesManagement;
import com.pms.PharmacyMS.salesManagement.repository.SalesRepo_SalesManagement;
import com.pms.PharmacyMS.salesManagement.dto.SalesDto_SalesManagement;
import com.pms.PharmacyMS.salesManagement.dto.Sales_Stock_View_Dto;
import com.pms.PharmacyMS.salesManagement.entity.SalesEntity_SalesManagement;
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
public class SalesManagementService {
    @Autowired
    private Sales_Stock_View_Repo sales_Stock_View_Repo;
    @Autowired
    private SalesRepo_SalesManagement salesRepoSalesManagement;
    @Autowired
    private SaleDetailRepo_SalesManagement seleDetailRepo_SalesManagement;
    @Autowired
    private ModelMapper modelMapper;



    // -------------------- Service for Sales_Stock_view-------------------START

    //Get all from service_stock_view
    public List<Sales_Stock_View_Dto> sales_stock_view(String inputBranchId){
        List<Sales_Stock_View_Entity> result = sales_Stock_View_Repo.sales_stock_view(inputBranchId);
        return modelMapper.map(result,new TypeToken<ArrayList<Sales_Stock_View_Dto>>(){}.getType());
    }


    // -------------------- Service for Sales_Stock_view-------------------END


    // -------------------------------- Service for sale TABLE -------------------STARY
    public void pay(String InputBranchId){
        salesRepoSalesManagement.pay(InputBranchId);
    }

    //get last bill record
    public SalesDto_SalesManagement getSalesByBillNo(){
        SalesEntity_SalesManagement sale =salesRepoSalesManagement.getlastBillrecord();
        return modelMapper.map(sale,SalesDto_SalesManagement.class);
    }


    // -------------------------------- Service for sale TABLE -------------------END




    // -------------------------------- Service for sale_detail TABLE -------------------START
    public void insertAllSaleDetails(List<SaleDetailsDto_SalesManagement> saleDetails){
        List<SaleDetailEntity_SAlesManagement> entityList = modelMapper.map(saleDetails, new TypeToken<List<SaleDetailEntity_SAlesManagement>>(){}.getType());

        SalesEntity_SalesManagement bill = salesRepoSalesManagement.getlastBillrecord();


        // Set bill_no for each entity in the list
        for (SaleDetailEntity_SAlesManagement entity : entityList) {
            entity.setBill_no(String.valueOf(bill.getBill_no()));
        }

        System.out.println(entityList);
        seleDetailRepo_SalesManagement.saveAll(entityList);
    }

    // -------------------------------- Service for sale_detail TABLE -------------------END


}
