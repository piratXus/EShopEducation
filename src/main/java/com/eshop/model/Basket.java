package com.eshop.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by raks on 22.09.16.
 *@Scope include String params are: singleton (только один экземпляр бина создается для IoC контейнера; значение по умолчанию )
 * , prototype (создается новый экземпляр бина когда приходит запрос на его создание)
 * , request (один экземпляр бина для каждого HTTP запроса ), session (один экземпляр бина для каждой сессии)
 * , globalSession (один экземпляр бина для каждой глобальной сессии)
 */
@Component
@Scope("prototype")
public class Basket {

    private int id;

    private String name_goods;

    private String full_user;

    private String name_seller;

    private int count_things;

    private int price_things;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_goods() {
        return name_goods;
    }

    public void setName_goods(String name_goods) {
        this.name_goods = name_goods;
    }
    public String getFull_user() {
        return full_user;
    }

    public void setFull_user(String full_user) {
        this.full_user = full_user;
    }

    public int getPrice_things() {
        return price_things;
    }

    public void setPrice_things(int price_things) {
        this.price_things = price_things;
    }

    public int getCount_things() {
        return count_things;
    }

    public void setCount_things(int count_things) {
        this.count_things = count_things;
    }

    public String getName_seller() {
        return name_seller;
    }

    public void setName_seller(String name_seller) {
        this.name_seller = name_seller;
    }
}
