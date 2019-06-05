/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.serviceimpl;

import com.itn.dao.NewsDao;
import com.itn.model.News;
import com.itn.service.NewsService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
     private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\mavenwebapp\\src\\main\\webapp\\resources";
    
    @Autowired
    private NewsDao newsDao;
    @Override
    public boolean addNews(News bl) {
        return newsDao.insert(bl);
    }

    @Override
    public List<News> findAllNews() {
         return newsDao.selectAll();
    }

    @Override
    public List<News> findNewsById(int id) {
        return newsDao.selectById(id);
    }

    @Override
    public List<News> findNewsByCategory(int category) {
           return newsDao.selectByCategory(category);
    }

    @Override
    public void updateNews(News bl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteNews(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean uploadImage(MultipartFile image) {
       boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "newsimage");
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

    @Override
    public List<News> findnewsByActivation() {
        return newsDao.selectByActivation();
    }

  
    
}
