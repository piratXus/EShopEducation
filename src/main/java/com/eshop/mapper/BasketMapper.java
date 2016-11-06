package com.eshop.mapper;

import com.eshop.model.Basket;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by raks on 05.11.16.
 */
public interface BasketMapper {
    String querySelect =
            "SELECT id AS ID,(SELECT name  FROM seller WHERE id = basket.id_seller) AS NAME_SELLER,(SELECT name FROM users WHERE id = basket.id_user) AS NAME_USER,\n" +
                    "  (SELECT title FROM goods WHERE id = basket.id_goods) AS NAME_GOODS,price_things AS PRICE_THINGS,count_things AS COUNT_THINGS FROM basket WHERE id_user = #{user_id}";
    @Select(querySelect)
    List<Basket> findBasketUserByIdUser(@Param("user_id") Integer user_id);
}
