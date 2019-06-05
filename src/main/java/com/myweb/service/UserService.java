/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.service;

import com.myweb.model.UserDetails;
import com.myweb.model.UserLogin;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author stim
 */
public interface UserService {
    
    boolean uploadImage(MultipartFile image);
    
    boolean saveUser(UserDetails ud);
     public List<UserDetails> findAllUser();
        
    public List<UserDetails> findUserById(int id);
    public List<Integer> findUserByUsername(String user);
    public void deleteUser(int id);
    
    
}
