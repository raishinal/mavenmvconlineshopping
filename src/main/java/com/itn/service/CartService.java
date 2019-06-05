/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.service;

import com.itn.model.Cart;
import java.util.List;

/**
 *
 * @author Raishin
 */
public interface CartService {
      public boolean addCart(Cart c);
    
    public List<Cart> findAllCart();
        
    public List<Cart> findCartById(int id);
    public List<Cart> findCartByUsername(String user);
    
     public void deleteCart(int id);
}
