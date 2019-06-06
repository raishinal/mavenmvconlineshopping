/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.controller;

import com.myweb.model.UserDetails;
import com.myweb.service.BlogService;
import com.myweb.service.CategoryService;
import com.myweb.service.NewsService;
import com.myweb.service.ProductService;
import com.myweb.service.UserService;
import java.security.Principal;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author stim
 */

@Controller
public class HomeController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDetails userDetails;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    @Autowired
    private NewsService newsService;
   
    
    @Autowired
    private  BlogService blogService;
    
    private int ustatus=0;
    
   @GetMapping("/Index")
    public ModelAndView showIndex(ModelAndView mv ,Principal p){

        mv.addObject("productlist", productService.findAllProduct());
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("sliderlist",newsService.findnewsByActivation() );
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
        mv.setViewName("index");
     
        return mv;
    }
   @GetMapping("/About")
    public ModelAndView showAbout(ModelAndView mv ,Principal p){
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
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("about");
        return mv;
    }
   @GetMapping("/Contact")
    public ModelAndView showContact(ModelAndView mv ,Principal p){
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
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.setViewName("contact");
        mv.addObject("status",ustatus);
        return mv;
    }
   @GetMapping("/Blog")
    public ModelAndView showBlog(ModelAndView mv, Principal p){
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
        mv.addObject("categorylist", categoryService.findMainCategory());
        mv.addObject("bloglist", blogService.findAllBlog());
        mv.setViewName("blog");
        return mv;
    }
    
      @GetMapping("/Blog/{id}")
    public ModelAndView showBlogById(@PathVariable int id, ModelAndView mv, Principal p){
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
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.addObject("blogitem", blogService.findBlogById(id));
        mv.setViewName("blogdetail");
        return mv;
    }
    
    
     @GetMapping("/News/Show/{id}")
    public ModelAndView showNewsById(@PathVariable int id, ModelAndView mv,Principal p){
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
        mv.addObject("categorylist", categoryService.findAllCategory());
        mv.addObject("newsitem", newsService.findNewsById(id));
        mv.setViewName("news");
        return mv;
    }
    
   
    @RequestMapping(value="/Admin/Register-user", method=RequestMethod.GET)
    public String userRegistration(){
       
        return "/registeruser";
    }
    
     
    @GetMapping("/Product/{id}")
    public ModelAndView showProductById(@PathVariable int id, ModelAndView mv ,Principal p){
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
        mv.addObject("productdetail", productService.findProductById(id));
        mv.setViewName("product");
        return mv;
    }
    @GetMapping("/Product/Category/Show")
    public ModelAndView showProductsCategory( ModelAndView mv,Principal p){
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
        mv.setViewName("itembycategory");
        return mv;
    }
    @GetMapping("/Product/Category/Show/{tag}")
    public ModelAndView showProductByCategory(@PathVariable String tag, ModelAndView mv,Principal p){
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
       mv.addObject("tagitem", productService.findProductByTags(tag));
        mv.setViewName("itembycategory");
        return mv;
    }
    
     
 
       
    
    
    @RequestMapping(value="/Admin/Registeruser", method=RequestMethod.POST)
    public String registerUser(
            
            @RequestParam("fname") String fname,
            @RequestParam("lname") String lname,
          
            @RequestParam("email") String email,
            @RequestParam("phone") long phone,
            @RequestParam("dob") String dob,
            @RequestParam("country") String country,
            @RequestParam("interest") String interest,
            @RequestParam("address") String address,
            @RequestParam("image") MultipartFile image,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("cpassword") String cpassword,
            @RequestParam("userType") String userType
            ){
      
        // password
       if(password.equals(cpassword)){
           userDetails.setPassword(passwordEncoder.encode(password));
       } 
       else{
           return "redirect:/Admin/Register-user?PasswordMismatch";
       }
       // image 
       if(!image.isEmpty()){
           if(userService.uploadImage(image)){
             userDetails.setImageName(image.getOriginalFilename());
           }
           else{
               return "redirect:/Admin/Register-user?ImageUploadFailed";
           }
       }
       else{
           return "redirect:/Admin/Register-user?ImageNotSelected";
       }
       
       // other form data
       userDetails.setFirstname(fname);
       userDetails.setLastname(lname);
    
       userDetails.setEmail(email);
       userDetails.setPhone(phone);
       userDetails.setDob(LocalDate.parse(dob));
       userDetails.setCountry(country);
       userDetails.setInterest(interest);
       userDetails.setAddress(address);
       userDetails.setUserName(username);
       userDetails.setUserType(userType);
       
       if(!userService.saveUser(userDetails)){
          return "redirect:/Register-user?UserRegistrationFailed"; 
       }
       
        return "redirect:/Register-user?Success";
    }
    
    
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model,Principal p) {
    
        model.addAttribute("user", p.getName());
        return "index";
    }
    
    
 
    
     
    
 
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model,Principal p) {
        model.addAttribute("user", p.getName());
        return "accessDenied";
    }
 
    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
 
    @RequestMapping(value="/Logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
        if (auth1 != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth1);
        }
        return "login";
    }
}
 
//    private String getPrincipal(){
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
// 
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails)principal).getName();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }

