/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.service;

import com.itn.model.News;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author roslm
 */

public interface NewsService {
        public boolean addNews(News bl);
    
    public List<News> findAllNews();
        
    public List<News> findNewsById(int id);
    public List<News> findNewsByCategory(int category);
    public List<News> findnewsByActivation();
    
    public void updateNews(News bl);
    
    public void deleteNews(int id);
    boolean uploadImage(MultipartFile image);
}
