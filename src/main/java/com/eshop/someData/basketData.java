package com.eshop.someData;

import com.eshop.configuration.DataConectionSourse;
import com.eshop.model.Basket;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raks on 20.09.16.
 */
@Component
public class basketData {

    private JdbcTemplate jdbcTemplate;

    public basketData(JdbcOperations jdbcOperations){
        this.jdbcTemplate = (JdbcTemplate) jdbcOperations;
    }

    List<Basket> data = new ArrayList<>();

    public List basketDataRet(){
//        DateTime date =  jdbcOperations.queryForObject("Select sysdate from dual", DateTime.class);
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
}
