package com.eshop.controller;

import com.eshop.someData.CollectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 19.09.2016.
 */
@Controller
public class startApp {
    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public ModelAndView homeController(ModelAndView modelAndView){
        modelAndView.addAllObjects( new ModelMap().addAttribute("firstString", "Hello world!!!").addAttribute("mapper", new CollectData().addDataToMap()));
        modelAndView.setViewName("home");
        return  modelAndView;
    }
}
