package com.eshop.controller;

import com.eshop.Interface.GoodsDataService;
import com.eshop.model.Goods;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 20.10.2016.
 */
@Controller
public class GoodsController {

    private static final Logger log = Logger.getLogger(GoodsController.class);

    @Autowired
    private GoodsDataService goodsDataService;

    @RequestMapping(value = "/allgoods", method = RequestMethod.GET)
    public ModelAndView AllGoods(ModelAndView modelAndView){
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsList",goodsDataService.FindAllGoods()));
        modelAndView.setViewName("/goods/allgoods");
        return modelAndView;
    }

    @RequestMapping(value = "/newgoods", method = RequestMethod.POST)
    public ModelAndView insertNewGoods (ModelAndView modelAndView, @RequestAttribute(name = "goods") Object goods){
        modelAndView.addAllObjects(new ModelMap().addAttribute("msg", goodsDataService.InsertInGoods((Goods) goods)));
        modelAndView.setViewName("/goods/allgoods");
        return modelAndView;
    }


    @RequestMapping(value = "/editgoods/{id}", method = RequestMethod.GET)
    public ModelAndView editItemGoods(@PathVariable("id") Long id, ModelAndView modelAndView){
        modelAndView.addAllObjects(new ModelMap().addAttribute("goods", goodsDataService.EditGoods(id)));
        modelAndView.setViewName("/goods/editForm");
        return modelAndView;
    }

    @RequestMapping(value = "/editgoods", method = RequestMethod.POST)
    public ModelAndView updateGoods(ModelAndView modelAndView, @RequestAttribute(name="goodsOne") Object goods){
        log.info(goods);
        log.info("update goods item id ");
        modelAndView.addAllObjects(new ModelMap().addAttribute("msg", goodsDataService.UpdateGoodsById((Goods)goods)));
        modelAndView.setViewName("/goods/allgoods");
        return modelAndView;
    }

    @RequestMapping(value = "detetegoods/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGoods(ModelAndView modelAndView, @PathVariable("id") Long id ){
        log.info("Delete goods item id"+id);
        modelAndView.addAllObjects(new ModelMap().addAttribute("msg", goodsDataService.DaleteGoodsById(id)));
        modelAndView.setViewName("/goods/allgoods");
        return modelAndView;
    }

    /**
     * Need add in interface one method and this implements
     * This block remove and need add in new Controller
     */
//    @RequestMapping(value = "/updatemygoods", method = RequestMethod.POST)
//    public ModelAndView updateMyGoods(ModelAndView modelAndView, @RequestAttribute(name="goodsOne") Object Strgoods){
////        modelAndView.addAllObjects(new ModelMap().addAttribute("msg", goodsDataService.UpdateGoodsById(goods)));
//        modelAndView.setViewName("/goods/mygoods");
//        return modelAndView;
//    }

}
