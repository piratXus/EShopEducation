package com.eshop.controller;

import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(AdminController.class);
//    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/main", method= RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/main");
        log.info("All in controller work!!!!");
        return modelAndView;
    }
}
