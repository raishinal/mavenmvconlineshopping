/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.controller;

import com.myweb.model.UserDetails;
import com.myweb.model.UserLogin;
import com.myweb.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author stim
 */
@Controller
public class AdminController {
     @Autowired
    private UserDetails userDetails;
     
    @Autowired
     UserService userService;
  private int ustatus=0;
    @GetMapping("/Admin/Home")
    public ModelAndView adminHome(ModelAndView mv,Principal p){
         
        mv.setViewName("admin/admindashboard");
        mv.addObject("user",p.getName() );
       
        return mv;
    }
    @GetMapping("/Admin/UserManagement")
    public ModelAndView user_Management(ModelAndView mv,Principal p){
         mv.addObject("user",p.getName() );
        mv.setViewName("admin/usermanagement");
        mv.addObject("userlist",userService.findAllUser());
        return mv;
    }
    
    @GetMapping("/Admin/Edit")
    public ModelAndView editAdmin(ModelAndView mv,Principal p){
           mv.addObject("user",p.getName() );

        mv.addObject("user",p.getName() );
//        List<Integer> userid=userService.findUserByUsername(p.getName());
//        mv.addObject("userdetail",userService.findUserById(userid.get(0)));
                mv.setViewName("admin/editadmin");
        return mv;
    }
    
    
    
    
}
