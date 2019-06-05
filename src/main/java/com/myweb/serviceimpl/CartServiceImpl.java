/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.serviceimpl;

import com.myweb.dao.CartDao;
import com.myweb.model.Cart;
import com.myweb.service.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Raishin
 */


@Service
@Transactional
public class CartServiceImpl implements CartService{
    
    @Autowired
    private CartDao cartDao;

    @Override
    public boolean addCart(Cart c) {
       return cartDao.insert(c);
    }

    @Override
    public List<Cart> findAllCart() {
        return cartDao.selectAll();
    }

    @Override
    public List<Cart> findCartById(int id) {
        return cartDao.selectById(id);
    }

    @Override
    public void deleteCart(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cart> findCartByUsername(String user) {
        return cartDao.selectByUsername(user);
    }
    
}
