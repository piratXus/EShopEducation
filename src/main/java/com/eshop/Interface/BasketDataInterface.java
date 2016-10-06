package com.eshop.Interface;

import com.eshop.model.Basket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.10.2016.
 */
public interface BasketDataInterface {
    List<Basket> data = new ArrayList<>();
    String deleteQuery = "DELETE from basket where id_user = ? and id_goods = ?";
    String querySelect = "SELECT id ID,(select name  from seller where id = basket.id_seller) NAME_SELLER," +
            "(Select name from user where id = basket.id_user) NAME_USER," +
            "(Select name from goods where id = basket.id_goods) NAME_GOODS," +
            "price_things PRICE_THINGS," +
            "count_things COUNT_THINGS" +
            " FROM basket where id_user = ?";
    List findAllItemsForUser(Long id_user);
    List deleteItemUser(Long id_user, int id_goods);

}
