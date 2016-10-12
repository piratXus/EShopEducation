package com.eshop.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by raks on 12.10.16.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Secured(value = {"ADMIN","SUPERADMIN"})
    @RequestMapping(value = "/main", method= RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/main");
        return modelAndView;
    }
}
