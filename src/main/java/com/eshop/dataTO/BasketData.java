package com.eshop.dataTO;

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
public class BasketData{

    private JdbcTemplate jdbcTemplate;

    public BasketData(JdbcOperations jdbcOperations){
        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
    }

    private List<Basket> data = new ArrayList<>();
    private String deleteQuery = "DELETE from basket where id_user = ? and id_goods = ?";
    private String querySelect = "SELECT * FROM basket where id_user = ?";

    public List basketDataRet(Long id_user){

        List<Map<String,Object>> rowsQuery = jdbcTemplate.queryForList(querySelect, new Object[] {id_user});
        for (Map row : rowsQuery) {
            Basket basket = new Basket();
            basket.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
            basket.setId_seller(Integer.parseInt(String.valueOf(row.get("ID_SELLER"))));
            basket.setId_user(Integer.parseInt(String.valueOf(row.get("ID_USER"))));
            basket.setId_goods(Integer.parseInt(String.valueOf(row.get("ID_GOODS"))));
            basket.setPrice_things(Integer.parseInt(String.valueOf(row.get("PRICE_THINGS"))));
            basket.setCount_things(Integer.parseInt(String.valueOf(row.get("COUNT_THINGS"))));
        }

        Date date = jdbcTemplate.queryForObject("Select sysdate() from dual", Date.class);
        System.out.println(date);
        Basket basket = new Basket();
        basket.setId(1);
        basket.setId_seller(1);
        basket.setId_user(2);
        basket.setPrice_things(120);
        basket.setCount_things(2);
        data.add(basket);
        return data;
    }

    public List deleteItem(Long id_user, int id_goods){
        System.out.println("Delete Item in table basket!");
//        jdbcTemplate.execute(deleteQuery, new Object[] {id_user, id_goods});
        return basketDataRet(id_user);
    }
}
