/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.controller;

import com.myweb.model.Cart;
import com.myweb.model.Product;
import com.myweb.service.CartService;
import com.myweb.service.CategoryService;
import com.myweb.service.ProductService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raishin
 */
@Controller
public class ProductController {
     private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String formattedDateTime = now.format(dtf);
      
      private int ustatus=0;
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
    
  @RequestMapping(value="/Admin/Product/Add", method=RequestMethod.GET)
   public ModelAndView addProduct(ModelAndView mv,Principal p){
          try{
            if(p.getName()!=null)
            {
                ustatus=1;
                mv.addObject("username",p.getName());
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
          mv.addObject("status",ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
                mv.addObject("tagslist", categoryService.findAllCategory());
        mv.setViewName("admin/addproduct");
        return mv;
    }
   
     @RequestMapping(value="/Admin/Product/Add", method=RequestMethod.POST)
    public String registerUser(@RequestParam("name") String name,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("specification") String specification,
            @RequestParam("price") double price,
            @RequestParam("stock") int stock,
            @RequestParam("image") MultipartFile image,Principal p
            
            ){
        
       // image 
       if(!image.isEmpty()){
           if(productService.uploadImage(image)){
             product.setImageName(image.getOriginalFilename());
           }
           else{
              return "redirect:/Admin/Product/Add?ImageNotUploaded";
           }
       }
       else{
       return "redirect:/Admin/Product/Add?ImageNotSelected";
       }
       
       // other form data
       product.setName(name);
       product.setCategory(category);
       product.setDescription(description);
       product.setStock(stock);
       product.setSpecification(specification);
       product.setTags(tags);
       product.setPrice(price);
       
        if(!productService.addProduct(product)){
        return "redirect:/Admin/Product/Add?Failed";
       }
        else{
            return "redirect:/Admin/Product/Add?Success";
        }
    }
      @GetMapping("/Admin/Product/Show")
    public ModelAndView showProducts(ModelAndView mv,Principal p){
           try{
            if(p.getName()!=null)
            {
                ustatus=1;
                mv.addObject("username",p.getName());
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
           mv.addObject("status",ustatus);
        mv.addObject("productlist", productService.findAllProduct());
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("admin/showproduct");
        return mv;
    }
    
    
    @RequestMapping(value="/Admin/Product/Delete/{id}", method=RequestMethod.GET)
   public ModelAndView deleteProduct(ModelAndView mv,@PathVariable int id,Principal p ){
          try{
            if(p.getName()!=null)
            {
                ustatus=1;
                mv.addObject("username",p.getName());
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
          mv.addObject("status",ustatus);
        if(productService.deleteProduct(id)){
        mv.addObject("status","success");

    }
        else{
            mv.addObject("status","failed");
        }
      return mv;
   }
   
    @RequestMapping(value="/Admin/Product/Edit/{id}", method=RequestMethod.GET)
   public ModelAndView editProduct(@PathVariable int id,ModelAndView mv,Principal p){
          try{
            if(p.getName()!=null)
            {
                ustatus=1;
                mv.addObject("username",p.getName());
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
          mv.addObject("status",ustatus);
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("product", productService.findProductById(id));
        mv.setViewName("admin/editproduct");
        return mv;
    }
   
   
    
    
      @RequestMapping(value="/Admin/Product/Update", method=RequestMethod.POST)
    public ModelAndView updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("category") int category,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam("imagename") String imagename,
            @RequestParam("image") MultipartFile image,
            ModelAndView mv,Principal p
            
            ){
           try{
            if(p.getName()!=null)
            {
                ustatus=1;
                mv.addObject("username",p.getName());
        }
        }
        catch(Exception e){
            System.out.println(e);
        }mv.addObject("status",ustatus);
      
       // image 
       if(!image.isEmpty()){
           if(productService.uploadImage(image)){
             product.setImageName(image.getOriginalFilename());
           }
           else{
               mv.addObject("status","imageuploadfailed");
           }
       }
       else{
          
           product.setImageName(imagename);
           
       }
       
       // other form data
       product.setId(id);
       product.setName(name);
       product.setCategory(category);
       product.setDescription(description);
       product.setPrice(price);
       
        if(!productService.updateProduct(product)){
         mv.addObject("status1","failed");
       }
        else{
            
        mv.addObject("status1","success");
        }
       return mv;
       
    }
    
    
   
    
   
   
    
}
