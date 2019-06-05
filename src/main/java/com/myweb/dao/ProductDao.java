/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.dao;

import com.myweb.model.Product;
import java.util.List;

/**
 *
 * @author Raishin
 */
public interface ProductDao {
    public boolean insert(Product pro);
    
    public List<Product> selectAll();
    
    public List<Product> selectById(int id);
    public List<Product> selectByCategory(int category);
    public List<Product> selectByTags(String tag);

    
    public boolean update(Product pro);
    
    public boolean delete(int id);
    
}
