/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.controller;

import com.myweb.model.Blog;
import com.myweb.service.BlogService;
import com.myweb.service.CategoryService;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class BlogController {
     private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String formattedDateTime = now.format(dtf);
      
      
    @Autowired
    private Blog blog;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    BlogService blogService;
    private int ustatus=0;
    @RequestMapping(value="/Admin/Blog/Add", method=RequestMethod.GET)
   public ModelAndView addBlog(ModelAndView mv,Principal p){
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
        mv.setViewName("admin/addblog");
        return mv;
    }
    @RequestMapping(value="/Admin/Blog/Show", method=RequestMethod.GET)
   public ModelAndView showBlog(ModelAndView mv,Principal p){
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
        mv.addObject("bloglist", blogService.findAllBlog());
        mv.setViewName("admin/displayblog");
        return mv;
    }
    @RequestMapping(value="/Admin/Blog/Add", method=RequestMethod.POST)
    public ModelAndView registerUser(@RequestParam("title") String title,
            @RequestParam("category") int category,
            @RequestParam("description") String description,
            @RequestParam("tags") String tags,
            @RequestParam("status") int status,
            
            @RequestParam("image") MultipartFile image,
            ModelAndView mv, Principal p
            
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
        }
         mv.addObject("status",ustatus);
       // image 
       if(!image.isEmpty()){
           if(blogService.uploadImage(image)){
             blog.setImageName(image.getOriginalFilename());
           }
           else{
               mv.addObject("status","ImageUploadFailed");
            
           }
       }
       else{
           mv.addObject("status","ImageNotSelected");
               
          
       }
       
       // other form data
       blog.setTitle(title);
       blog.setCategory(category);
       blog.setDescription(description);
       blog.setTags(tags);
       blog.setStatus(status);
       blog.setNow(formattedDateTime);

       
       
        if(!blogService.addBlog(blog)){
            mv.addObject("status","UserRegistrationFailed");
   
       }
        else{
            mv.addObject("status","Success");
               
        }
        return mv;
    }
   
}
