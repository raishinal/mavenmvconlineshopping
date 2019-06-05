/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.service;

import com.itn.model.Blog;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */
public interface BlogService {
      public boolean addBlog(Blog bl);
    
    public List<Blog> findAllBlog();
        
    public List<Blog> findBlogById(int id);
    public List<Blog> findBlogByCategory(int category);
    public List<Blog> findBlogByActivation();
    
    public void updateBlog(Blog bl);
    
    public void deleteBlog(int id);
    boolean uploadImage(MultipartFile image);
}
