/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.controller;

import com.myweb.model.News;
import com.myweb.service.CategoryService;
import com.myweb.service.NewsService;
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
 * @author roslm
 */
@Controller
public class NewsController {
    private int ustatus=0;
     private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String formattedDateTime = now.format(dtf);
      
      
    @Autowired
    private News news;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    NewsService newsService;
    
    @RequestMapping(value="/Admin/News/Add", method=RequestMethod.GET)
   public ModelAndView addNews(ModelAndView mv,Principal p){
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
        mv.setViewName("admin/addnews");
        return mv;
    }
    @RequestMapping(value="/Admin/News/Show", method=RequestMethod.GET)
   public ModelAndView showNews(ModelAndView mv,Principal p){
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
        mv.addObject("tagslist", categoryService.findAllCategory());
        mv.addObject("newslist", newsService.findAllNews());
        mv.setViewName("admin/displaynews");
        return mv;
    }
    @RequestMapping(value="/Admin/News/Add", method=RequestMethod.POST)
    public String registerNews(@RequestParam("title") String title,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("status") int status,
            
            @RequestParam("image") MultipartFile image,Principal p
            ){
        
      
       // image 
       if(!image.isEmpty()){
           if(newsService.uploadImage(image)){
             news.setImageName(image.getOriginalFilename());
           }
           else{
              return "redirect:/Admin/News/Add?ImageUploadFailed";
       }
       }
       else{
                        return "redirect:/Admin/News/Add?ImageNotSelected";
         
       }
       
       // other form data
       news.setTitle(title);
       news.setTags(tags);
       news.setDescription(description);
       news.setStatus(status);
       news.setNow(formattedDateTime);

       
       
        if(!newsService.addNews(news)){
                       return "redirect:/Admin/News/Add?Failed";
       }
        else{
                    return "redirect:/Admin/News/Add?Success";
        }
 
    }
   
}
