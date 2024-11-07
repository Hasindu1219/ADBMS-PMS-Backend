package com.pms.PharmacyMS.salesManagement.repository;

import com.pms.PharmacyMS.salesManagement.entity.Sales_Stock_View_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface Sales_Stock_View_Repo extends JpaRepository<Sales_Stock_View_Entity,Integer> {

    //Procedure to get the stock details to sales component
    @Procedure (name = "sales_stock_view")
    List<Sales_Stock_View_Entity> sales_stock_view(String inputBranchId);
}
