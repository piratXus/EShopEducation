package com.eshop.someData;

import com.eshop.model.Basket;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by raks on 20.09.16.
 */
@Component
public class BasketData {

    private JdbcTemplate jdbcTemplate;

    public BasketData(JdbcOperations jdbcOperations){
        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
    }

    List<Basket> data = new ArrayList<>();

    public List basketDataRet(Long id_user){

        String query = "SELECT * FROM basket where id_user ="+id_user;
        List<Map<String,Object>> rowsQuery = jdbcTemplate.queryForList(query);
        for (Map row : rowsQuery) {
            Basket basket = new Basket();
            basket.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
            basket.setId(Integer.parseInt(String.valueOf(row.get("ID_SELLER"))));
            basket.setId(Integer.parseInt(String.valueOf(row.get("ID_USER"))));
            basket.setId(Integer.parseInt(String.valueOf(row.get("PRICE_THINGS"))));
            basket.setId(Integer.parseInt(String.valueOf(row.get("COUNT_THINGS"))));
        }

        jdbcTemplate.queryForObject("Select sysdate() from dual", Date.class);
//        System.out.println(date);
        Basket basket = new Basket();
        basket.setId(1);
        basket.setId_seller(1);
        basket.setId_user(2);
        basket.setPrice_things(120);
        basket.setCount_things(2);
        data.add(basket);
        return data;
    }

    public List deleteItem(Long id_user){
        System.out.println("Delete Item in table basket!");
        return basketDataRet(id_user);
    }
}
