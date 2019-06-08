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
import java.util.List;
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
public class BlogController {
     private final  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
         mv.addObject("user",p.getName() );
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("tagslist", categoryService.findAllCategory());
        mv.setViewName("admin/addblog");
        return mv;
    }
   @GetMapping("/Admin/Blog/Show")
   public ModelAndView showBlog(ModelAndView mv,Principal p){
        mv.addObject("user",p.getName() );
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("bloglist", blogService.findAllBlog());
        mv.setViewName("admin/displayblog");
        return mv;
    }
   @RequestMapping(value="/Admin/Blog/Add", method=RequestMethod.POST)
    public String registerUser(@RequestParam("title") String title,
            @RequestParam("category") int category,
            @RequestParam("description") String description,
            @RequestParam("tags") String tags,
            @RequestParam("status") int status,
            
            @RequestParam("image") MultipartFile image,Principal p
            
            ){
//         try{
//            if(p.getName()!=null)
//            {
//                ustatus=1;
//               return "redirect:/Admin/Blog/Add?ImageNotUploaded";
//        }
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//         mv.addObject("status",ustatus);
       // image 
       if(!image.isEmpty()){
           if(blogService.uploadImage(image)){
             blog.setImageName(image.getOriginalFilename());
           }
           else{
               return "redirect:/Admin/Blog/Add?ImageNotUploaded";
            
           }
       }
       else{
          return "redirect:/Admin/Blog/Add?ImageNotSelected";
               
          
       }
       
       // other form data
       blog.setTitle(title);
       blog.setCategory(category);
       blog.setDescription(description);
       blog.setTags(tags);
       blog.setStatus(status);
       blog.setNow(formattedDateTime);

       
       
        if(!blogService.addBlog(blog)){
            return "redirect:/Admin/Blog/Add?RegistrationFailed";
   
       }
        else{
            return "redirect:/Admin/Blog/Add?Success";
               
        }

    }
    
    
    
        @RequestMapping(value="/Admin/Blog/Delete/{id}", method=RequestMethod.GET)
   public String deleteBlog(@PathVariable int id,Principal p ){
        if(blogService.deleteBlog(id)){
        return "redirect:/Admin/Blog/Show?Success";

    }
        else{
           return "redirect:/Admin/Blog/Show?Failed";
        }
   }
   
    @RequestMapping(value="/Admin/Blog/Edit/{id}", method=RequestMethod.GET)
   public ModelAndView editProduct(@PathVariable int id,ModelAndView mv,Principal p){
          mv.addObject("user",p.getName() );
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("tags", categoryService.findAllCategory());
        mv.addObject("blog", blogService.findBlogById(id));
        mv.setViewName("admin/editblog");
        return mv;
    }
   
   
   
      @RequestMapping(value="/Admin/Blog/Update", method=RequestMethod.POST)
    public String updateBlog(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("category") int category,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("status") int status,
            @RequestParam("imagename") String imagename,
            @RequestParam("image") MultipartFile image
            
            ){
        
        
        List<Blog> bl=blogService.findBlogById(id);
        blog.setNow(bl.get(0).getNow());
        if(!image.isEmpty()){
           if(blogService.uploadImage(image)){
             blog.setImageName(image.getOriginalFilename());
           }
           else{
                     return "redirect:/Admin/Blog/Show?image upload failed";
           }
       }
       else{
          
          blog.setImageName(imagename);
           
       }
      blog.setId(id);
      blog.setTitle(title);
      blog.setTags(tags);
      blog.setCategory(category);
      blog.setDescription(description);
      blog.setStatus(status);
       
        if(!blogService.updateBlog(blog)){
         return "redirect:/Admin/Blog/Show?Failed";
       }
        else{
             return "redirect:/Admin/Blog/Show?Success";
        }
    }
    
   
}
