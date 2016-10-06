package com.eshop.dataTO;

import com.eshop.Interface.BasketDataInterface;
import com.eshop.model.Basket;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by raks on 20.09.16.
 */
@Component
public class BasketData implements BasketDataInterface{

    private JdbcTemplate jdbcTemplate;

    public BasketData(JdbcOperations jdbcOperations){
        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
    }

    @Override
    public List findAllItemsForUser(Long id_user){

        List<Map<String,Object>> rowsQuery = jdbcTemplate.queryForList(querySelect, new Object[] {id_user});
        for (Map row : rowsQuery) {
            Basket basket = new Basket();
            basket.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
            basket.setName_seller(String.valueOf(row.get("NAME_SELLER")));
            basket.setFull_user(String.valueOf(row.get("NAME_USER")));
            basket.setName_goods(String.valueOf(row.get("NAME_GOODS")));
            basket.setPrice_things(Integer.parseInt(String.valueOf(row.get("PRICE_THINGS"))));
            basket.setCount_things(Integer.parseInt(String.valueOf(row.get("COUNT_THINGS"))));
            dataList.add(basket);
        }
        return dataList;
    }
    @Override
    public List deleteItemUser(Long id_user, Basket basket){
        System.out.println("Delete Item in table basket!");
        jdbcTemplate.update(deleteQuery, new Object[] {id_user, basket.getId()});
        dataList.remove(basket);
        System.out.println(dataList.isEmpty());
        return dataList;
    }
}
