package com.eshop.dataTO;

import com.eshop.Interface.GoodsDataService;
import com.eshop.model.Goods;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 20.10.2016.
 */
@Component
public class GoodsDataServiceImpl implements GoodsDataService {

    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(GoodsDataServiceImpl.class);

    private List<Goods> dataGoods = new ArrayList<>();

    @Autowired
    public GoodsDataServiceImpl(JdbcOperations jdbcTemplate){
        this.jdbcTemplate = (JdbcTemplate) jdbcTemplate;
    }

    @Override
    public List FindAllGoods() {
        try {
            List<Map<String, java.lang.Object>> collectionGoods = jdbcTemplate.queryForList(findAll);
            for (Map row : collectionGoods) {
                Goods goods = new Goods();
                goods.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
                goods.setId_company(Integer.parseInt(String.valueOf(row.get("ID_COMPANY"))));
                goods.setName_company(String.valueOf(row.get("NAME_COMPANY")));
                goods.setTitle(String.valueOf(row.get("TITLE")));
                goods.setDescription(String.valueOf(row.get("DESCRIPTION")));

                dataGoods.add(goods);
            }
        } catch (Exception e){
            log.error(e);
        }
        return dataGoods;
    }

    @Override
    public String InsertInGoods(Goods goods) {
        String msg;
        try {
            jdbcTemplate.update(insertGoods, new java.lang.Object[]{goods.getId_company(), null, goods.getDescription(),
                    goods.getTitle()});
            msg = "Successfully!";
        } catch (Exception e){
            log.error(e);
            msg = "Error, please go to home page!";
        }
        dataGoods.add(goods);

        return msg;
    }

    @Override
    public String UpdateGoodsById(Goods goods) {
        String msg;
        try {
            jdbcTemplate.update(updateGoods, new java.lang.Object[]{goods.getId_company(), null, goods.getDescription(),
                    goods.getTitle()});
            msg = "Successfully!";
        } catch (Exception e){
            log.error(e);
            msg = "Error, please go to home page!";
        }
        dataGoods.remove(dataGoods.stream().filter(dataGoods1-> dataGoods.equals(dataGoods1)).findAny().orElse(null));
        dataGoods.add(goods);
        return msg;
    }

    @Override
    public String DaleteGoodsById(Long id) {
        String msg;
        try {
            jdbcTemplate.update(deleteGoods, new java.lang.Object[]{id});
            msg = "Successfully!";
        } catch(Exception e){
            log.error(e);
            msg = "Error, please go to home page!";
        }
        dataGoods.remove(dataGoods.stream().filter(dataGoods1 -> id.equals(dataGoods1.getId())).findAny().orElse(null));
        return msg;
    }

    @Override
    public Object EditGoods(Long id){
        return jdbcTemplate.queryForObject(selectById, new Object[]{id},Goods.class);
    }

    @Override
    public List GetListGoods(){
        return dataGoods;
    }
}
