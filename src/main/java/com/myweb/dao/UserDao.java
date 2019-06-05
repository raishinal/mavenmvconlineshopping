/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.dao;

import com.myweb.model.UserDetails;
import com.myweb.model.UserLogin;
import java.util.List;

/**
 *
 * @author stim
 */
public interface UserDao {
    
    boolean insert(UserDetails ud);
     public List<UserDetails> selectAll();
    
    public List<UserDetails> selectById(int id);
    public List<Integer> selectByUsername(String user);
     public void delete(int id);
   
    
    
    
}
