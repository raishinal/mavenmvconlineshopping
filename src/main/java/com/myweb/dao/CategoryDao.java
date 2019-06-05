/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.dao;

import com.myweb.model.Category;
import java.util.List;

/**
 *
 * @author stim
 */
public interface CategoryDao {
    
    public void insert(Category cat);
    
    public List<Category> selectAll();
    
    public List<Category> selectMain();
  
    
    public List<Category> selectById(int id);
    public List<Category> selectByPid();
    
    public boolean update(Category cat);
    
    public boolean delete(int id);
}
