package com.eshop.dataTO;

import com.eshop.Interface.BasketDataService;
import com.eshop.model.Basket;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by raks on 20.09.16.
 */
@Component
public class BasketDataServiceImpl implements BasketDataService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BasketDataServiceImpl(JdbcOperations jdbcOperations){
        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
    }

    @Override
    public List findAllItemsForUser(String id_user){

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
        Basket basket = new Basket();
        basket.setId(1);
        basket.setName_goods("Ked");
        basket.setName_seller("Bess");
        basket.setPrice_things(12);
        basket.setCount_things(2);
        dataList.add(basket);
        return dataList;
    }
    @Override
    public List deleteItemUser(String id_user, Integer basket){
        System.out.println("Delete Item in table basket!");
        jdbcTemplate.update(deleteQuery, new Object[] {id_user, basket});
        System.out.println(dataList.stream().filter(basket1 -> basket.equals(basket1.getId())));
        dataList.remove(dataList.stream().filter(basket1 -> basket.equals(basket1.getId())));
        System.out.println(dataList.isEmpty());
        return dataList;
    }

    @Override
    public String addItemUserInBasket(String id_user, Objects objects){
        jdbcTemplate.update(insertQuery, new Object[]{objects.hashCode()});
        return "Success insert";
    }
}
