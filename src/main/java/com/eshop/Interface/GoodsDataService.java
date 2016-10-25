package com.eshop.Interface;

import com.eshop.model.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 20.10.2016.
 */
public interface GoodsDataService {
    String findAll = "Select id, id_company, (Select name from eshop.company where id = id_company) name_company, description," +
            "title from eshop.goods;";
    String insertGoods = "Insert into goods (id_company, id_img, description, title) values (?,?,?,?);";
    String updateGoods = "Update goods set id_company = ?, id_img = ?, description = ?, title = ?," +
            "where id = ?;";
    String selectById = "Select id, id_company, (Select name from eshop.company where id = id_company) name_company, description," +
            "title from eshop.goods;";
    String deleteGoods = "Delete goods where id = ?;";

    List FindAllGoods();
    String InsertInGoods(Goods goods);
    String UpdateGoodsById(Goods goods);
    String DaleteGoodsById(Long id);
    Object EditGoods(Long id);
    List GetListGoods();
}
