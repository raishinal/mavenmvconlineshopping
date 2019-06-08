/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.service;

import com.myweb.model.Blog;
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
    
    public boolean updateBlog(Blog bl);
    
    public boolean deleteBlog(int id);
    boolean uploadImage(MultipartFile image);
}
