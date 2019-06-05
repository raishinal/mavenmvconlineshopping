/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.controller;

import com.itn.model.Category;
import com.itn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author stim
 */
@Controller
public class CategoryController {
      
    @Autowired
    private Category category;
    
    @Autowired
    CategoryService categoryService;
    
    @GetMapping("/Admin/Category/Add")
    public ModelAndView addCategory(ModelAndView mv){
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.setViewName("admin/addcategory");
        return mv;
    }
    
    @PostMapping("/Admin/Category/Add")
    public ModelAndView saveCategory(ModelAndView mv,
                                    @ModelAttribute Category cat){
        System.out.println(cat.toString());
        categoryService.addCategory(cat);
        
        mv.setViewName("redirect:/Admin/Category/Add");
        return mv;
    }
    
    
    @GetMapping("/Admin/Category/Show")
    public ModelAndView showCategories(ModelAndView mv){
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("admin/showcategory");
        return mv;
    }
    
    
    
    
    @RequestMapping(value="/Admin/Category/Delete/{id}", method=RequestMethod.GET)
   public String deleteProduct(@PathVariable int id ){
       
        if(categoryService.deleteCategory(id)){
         return "redirect:/Admin/Category/Show?Delete success"; 

    }
        else{
            return "redirect:/Admin/Category/Show?DeleteFailed"; 
        }
      
   }
   
    @RequestMapping(value="/Admin/Category/Edit/{id}", method=RequestMethod.GET)
   public ModelAndView editProduct(@PathVariable int id,ModelAndView mv){
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("category", categoryService.findCategoryById(id));
        mv.setViewName("admin/editcategory");
        return mv;
    }
   
   
    
    
      @RequestMapping(value="/Admin/Category/Update", method=RequestMethod.POST)
    public String updateUser(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("tags") String tags,
            @RequestParam("description") String description,
            @RequestParam("pid") int pid
            
            ){
      
      
      category.setId(id);
      category.setTitle(title);
      category.setTags(tags);
      category.setDescription(description);
      category.setPid(pid);
       
        if(!categoryService.updateCategory(category)){
          return "redirect:/Admin/Category/Show?Failure"; 
       }
       
       
        return "redirect:/Admin/Category/Show?Success";
    }
    
    
   
}
