package com.eshop.controller;

import com.eshop.Interface.BasketDataService;
import com.eshop.model.Basket;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raks on 20.09.16.
 */
@Controller
@RequestMapping("/basket")
public class BasketController {

    private static final Logger log = Logger.getLogger(BasketController.class);

    @Autowired
    BasketDataService basketData;

    @RequestMapping(value="/findbasket", method= RequestMethod.GET)
    public ModelAndView Basket(ModelAndView modelAndView, @CookieValue(value="userIndet", defaultValue = "0") String userCookie){
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", basketData.findAllItemsForUser(userCookie)));
        modelAndView.setViewName("basket");
        log.info("Controller work all is good!!!");
        return modelAndView;
    }

//    @RequestMapping(value="/deletebasket", method= RequestMethod.POST)
//    public ModelAndView BasketDelete(@RequestParam("key") Integer basket,ModelAndView modelAndView, @CookieValue(value="userIndet", defaultValue = "0") String userCookie){
//        log.info(basket);
//        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", basketData.deleteItemUser(userCookie, basket)));
//        modelAndView.setViewName("basket");
//        return modelAndView;
//    }
}
