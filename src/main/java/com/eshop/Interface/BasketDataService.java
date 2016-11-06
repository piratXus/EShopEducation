package com.eshop.Interface;

import com.eshop.model.Basket;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by User on 06.10.2016.
 */
@Scope("session")
public interface BasketDataService {
    List<Object> dataList = new ArrayList<>();
//    String deleteQuery = "DELETE from basket where id_user = ? and id_goods = ?";
//    String querySelect = "SELECT id ID,(select name  from seller where id = basket.id_seller) NAME_SELLER," +
//            "(Select name from user where id = basket.id_user) NAME_USER," +
//            "(Select title from goods where id = basket.id_goods) NAME_GOODS," +
//            "price_things PRICE_THINGS," +
//            "count_things COUNT_THINGS" +
//            " FROM basket where id_user = ?";
//    String insertQuery = "Insert into basket (id_goods, id_user, id_seller, count_things, price_things) values(?,?,?,?,?)";
    List findAllItemsForUser(String id_user);
//    List deleteItemUser(String id_user, Integer basket);
//    String addItemUserInBasket(String id_user, Objects objects);

}
