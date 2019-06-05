/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raishin
 */
@Controller
public class UserController {
    @GetMapping("/User/Home")
    public ModelAndView adminHome(ModelAndView mv, Principal p){
        mv.setViewName("user/userhome");
        mv.addObject("user",p.getName());
        return mv;
    }
    
}
