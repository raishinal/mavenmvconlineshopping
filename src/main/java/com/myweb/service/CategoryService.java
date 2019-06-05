/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.service;

import com.myweb.model.Category;
import java.util.List;

/**
 *
 * @author stim
 */
public interface CategoryService {
    
    public void addCategory(Category cat);
    
    public List<Category> findAllCategory();
    
    public List<Category> findMainCategory();
    
    public List<Category> findCategoryById(int id);
    public List<Category> findCategoryByPid();
    
    public boolean updateCategory(Category cat);
    
    public boolean deleteCategory(int id);
    
    
}
