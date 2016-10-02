package com.eshop.controller;

import com.eshop.dataTO.BasketData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raks on 20.09.16.
 */
@Controller
public class BasketController {

    @Autowired
    BasketData basketData;

    @RequestMapping(value="/basket", method= RequestMethod.GET)
    public ModelAndView Basket(ModelAndView modelAndView, @CookieValue(value="userIndet", defaultValue = "0") Long userCookie){
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", basketData.basketDataRet(userCookie)));
        modelAndView.setViewName("basket");
        return modelAndView;
    }

    @RequestMapping(value="/basket", method= RequestMethod.POST)
    public ModelAndView BasketDelete(@RequestParam("key") int basket,ModelAndView modelAndView, @CookieValue(value="userIndet", defaultValue = "0") Long userCookie){
        System.out.println(basket);
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", basketData.deleteItem(userCookie, basket)));
        modelAndView.setViewName("basket");
        return modelAndView;
    }
}
