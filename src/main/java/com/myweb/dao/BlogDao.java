/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.dao;

import com.myweb.model.Blog;
import java.util.List;

/**
 *
 * @author Raishin
 */
public interface BlogDao {
        public boolean insert(Blog bl);
    
    public List<Blog> selectAll();
    
    public List<Blog> selectById(int id);
    public List<Blog> selectByCategory(int category);
    public List<Blog> selectByActivation();
    
    public boolean update(Blog bl);
    
    public boolean delete(int id);
    
}
