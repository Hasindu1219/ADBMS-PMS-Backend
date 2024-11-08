package com.pms.PharmacyMS.Management_DU.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class DashboardService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getTodaySalesCount() {
        String query = "SELECT count(sold_date) AS todays_sales_until_now FROM sale WHERE DATE(sold_date) = CURDATE();";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public Double getTodayIncome() {
        String query = "SELECT SUM(sale_details.quantity * sale_details.sold_item_unit_price) AS todays_income_until_now FROM sale_details INNER JOIN sale ON sale_details.bill_no = sale.bill_no WHERE DATE(sale.sold_date) = CURDATE()";
        return jdbcTemplate.queryForObject(query, Double.class);
    }

    public Map<String, Object> getYesterdayIncomeAndSales() {
        String query = "SELECT * FROM daily_sales_summary WHERE summary_date = CURDATE() - INTERVAL 1 DAY";
        try {
            return jdbcTemplate.queryForMap(query);

        }catch (DataAccessException e){
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public List<Map<String, Object>> getMonthlyIncomeAndSales() {
        String query = "SELECT * FROM daily_sales_summary WHERE MONTH(summary_date) = MONTH(CURDATE()) AND YEAR(summary_date) = YEAR(CURDATE())";
        try {
            return jdbcTemplate.queryForList(query);

        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Map<String, Object>> getGoodsNearExpiration() {
        String query = "SELECT * FROM inventory WHERE expiry_date BETWEEN CURDATE() AND LAST_DAY(CURDATE()) AND quantity > 0";
        return jdbcTemplate.queryForList(query);
    }

    public List<Map<String, Object>> getMostSoldMedicines() {
        String query = "select medicine.medicine_name from sale inner join sale_details on sale.bill_no = sale_details.bill_no\n" +
                "inner join medicine on sale_details.medicine_id = medicine.medicine_id\n" +
                "where month(sale.sold_date) = month(curdate() - interval 1 month )\n" +
                "and year(sale.sold_date) = year(curdate() -interval 1 month )\n" +
                "group by sale_details.medicine_id order by sale_details.quantity desc limit 10";

        try {
            return jdbcTemplate.queryForList(query);

        }catch (DataAccessException e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


}
