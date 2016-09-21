package com.eshop.controller;

import com.eshop.someData.basketData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raks on 20.09.16.
 */
@Controller
public class basketController {

    @RequestMapping(value="/basket", method= RequestMethod.GET)
    public ModelAndView Basket(ModelAndView modelAndView){
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", new basketData().basketDataRet()));
        modelAndView.setViewName("basket");
        return modelAndView;
    }

    @RequestMapping(value="/basket", method= RequestMethod.POST)
    public ModelAndView BasketDelete(@RequestParam("key") String basket,ModelAndView modelAndView){
        System.out.println(basket);
        modelAndView.addAllObjects(new ModelMap().addAttribute("goodsInBasket", new basketData().basketDataRet()));
        modelAndView.setViewName("basket");
        return modelAndView;
    }
}
