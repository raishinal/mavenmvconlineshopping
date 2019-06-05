/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.model.News;
import java.util.List;

/**
 *
 * @author roslm
 */
public interface NewsDao {
        public boolean insert(News bl);
    
    public List<News> selectAll();
    
    public List<News> selectById(int id);
    public List<News> selectByCategory(int category);
    public List<News> selectByActivation();
    
    public void update(News bl);
    
    public void delete(int id);
}
