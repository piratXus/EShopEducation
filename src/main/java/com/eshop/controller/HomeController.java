package com.eshop.controller;

import com.eshop.dataTO.CollectData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 19.09.2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public ModelAndView homeController(ModelAndView modelAndView,HttpServletResponse response, @CookieValue(value="userIndet", defaultValue = "0") Long userCookie){
        modelAndView.addAllObjects( new ModelMap().addAttribute("firstString", "Hello world!!!").addAttribute("mapper", new CollectData().addDataToMap()));
        modelAndView.setViewName("home");
        if(userCookie == 0) {
            response.addCookie(new Cookie("userIndet", "1"));
        }
        return  modelAndView;
    }
}
