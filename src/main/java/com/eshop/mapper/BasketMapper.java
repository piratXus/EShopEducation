package com.eshop.mapper;

import com.eshop.model.Basket;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by raks on 05.11.16.
 */
public interface BasketMapper {
    String querySelect =
            "SELECT id as ID,(select name  from seller where id = basket.id_seller) as NAME_SELLER," +
            "(Select name from user where id = basket.id_user) as NAME_USER," +
            "(Select title from goods where id = basket.id_goods) as NAME_GOODS," +
            "price_things as PRICE_THINGS," +
            "count_things as COUNT_THINGS" +
            " FROM basket WHERE id_user = #{user_id}";
    @Select(querySelect)
//    @ResultMap("com.eshop.model.Basket")
    List<Basket> findBasketUserByIdUser(@Param("user_id") String user_id);
}
