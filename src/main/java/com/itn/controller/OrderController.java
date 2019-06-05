/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.controller;

import com.itn.model.Cart;
import com.itn.model.Product;
import com.itn.service.CartService;
import com.itn.service.CategoryService;
import com.itn.service.ProductService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raishin
 */
@Controller
public class OrderController {
    
    private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String formattedDateTime = now.format(dtf);
      
          @Autowired
    private Product product;
    @Autowired
    private Cart cart;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    CartService cartService;
    
    @Autowired
    ProductService productService;
      
      @RequestMapping(value="/User/Purchase/{id}", method=RequestMethod.GET)
   public ModelAndView addCart(@PathVariable int id,ModelAndView mv,Principal p){
        mv.addObject("product", productService.findProductById(id));
         List<Product> pro= productService.findProductById(id);
        Product pd=pro.get(0);
        cart.setUsername(p.getName());
        cart.setProductid(pd.getId());
        cart.setProductname(pd.getName());
        cart.setOrderdate(formattedDateTime);
        if(cartService.addCart(cart)){
       mv.addObject("success");
 
    }
        else{
       mv.addObject("failure");  
        }
             mv.setViewName("user/userhome");
        return mv;
    }
   
    
    @RequestMapping(value="/Admin/Order", method=RequestMethod.GET)
   public ModelAndView showOrder(ModelAndView mv){

        mv.addObject("cartlist", cartService.findAllCart());
        mv.setViewName("admin/ordermanagement");
        return mv;
    }
   
   
   
    @RequestMapping(value="/User/Cart", method=RequestMethod.GET)
   public ModelAndView showCart(ModelAndView mv,Principal p){

        mv.addObject("cartlist", cartService.findCartByUsername(p.getName()));
        mv.setViewName("user/userorder");
        return mv;
    }
   
   
   
}
