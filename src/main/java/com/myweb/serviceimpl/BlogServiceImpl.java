/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.serviceimpl;

import com.myweb.dao.BlogDao;
import com.myweb.model.Blog;
import com.myweb.service.BlogService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */

@Service
@Transactional
public class BlogServiceImpl implements BlogService{
 private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\mavenwebapp\\src\\main\\webapp\\resources";
    
    @Autowired
    private BlogDao blogDao;
    @Override
    public boolean addBlog(Blog bl) {
        return blogDao.insert(bl);
    }

    @Override
    public List<Blog> findAllBlog() {
         return blogDao.selectAll();
    }

    @Override
    public List<Blog> findBlogById(int id) {
        return blogDao.selectById(id);
    }

    @Override
    public List<Blog> findBlogByCategory(int category) {
           return blogDao.selectByCategory(category);
    }

    @Override
    public List<Blog> findBlogByActivation() {
          return blogDao.selectByActivation();
    }

    @Override
    public boolean updateBlog(Blog bl) {
        return blogDao.update(bl);
    }

    @Override
    public boolean deleteBlog(int id) {
        return blogDao.delete(id);
    }

    @Override
    public boolean uploadImage(MultipartFile image) {
       boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "blogimage");
        if(!dir.exists()){
            dir.mkdirs();
        }
       
        
       String filename = image.getOriginalFilename();
       File uploadImage = new File(dir + File.separator +filename);
       try{
           image.transferTo(uploadImage);
           status = true;
       }catch(Exception e){
           System.out.println(e); 
       }
        
        return status;
    }
    
}
