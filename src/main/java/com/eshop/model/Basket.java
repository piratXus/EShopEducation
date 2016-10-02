package com.eshop.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by raks on 22.09.16.
 */
@Component
public class Basket {

    private int id;

    private int id_goods;

    private int id_user;

    private int id_seller;

    private int count_things;

    private int price_things;

    public int getId_goods() {
        return id_goods;
    }

    public void setId_goods(int id_goods) {
        this.id_goods = id_goods;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_seller() {
        return id_seller;
    }

    public void setId_seller(int id_seller) {
        this.id_seller = id_seller;
    }

    public int getCount_things() {
        return count_things;
    }

    public void setCount_things(int count_things) {
        this.count_things = count_things;
    }

    public int getPrice_things() {
        return price_things;
    }

    public void setPrice_things(int price_things) {
        this.price_things = price_things;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
