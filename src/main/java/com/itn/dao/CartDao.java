/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.dao;

import com.itn.model.Cart;
import java.util.List;

/**
 *
 * @author Raishin
 */
public interface CartDao {
     public boolean insert(Cart c);
    
    public List<Cart> selectAll();
    
    public List<Cart> selectById(int id);
    public List<Cart> selectByUsername(String user);
    
        public void delete(int id);
}
