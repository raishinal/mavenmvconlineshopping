/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.serviceimpl;

import com.itn.dao.UserDao;
import com.itn.model.UserDetails;
import com.itn.model.UserLogin;
import com.itn.service.UserService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author stim
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    
    private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\mavenwebapp\\src\\main\\webapp\\resources";
    
    @Autowired
    private UserDao userDao;

    @Override
    public boolean uploadImage(MultipartFile image) {
        boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "userimage");
        if(!dir.exists()){
            dir.mkdirs();
        }
       
        
       String filename = image.getOriginalFilename();
       File uploadImage = new File(dir + File.separator +filename);
       try{
           image.transferTo(uploadImage);
           status = true;
       }catch(Exception e){
           System.out.println(e); 
       }
        
        return status;
    }

    
    @Override
    public boolean saveUser(UserDetails ud) {
        return userDao.insert(ud);
    }

    @Override
    public List<UserDetails> findAllUser() {
     return userDao.selectAll();
    }

    @Override
    public List<UserDetails> findUserById(int id) {
       return userDao.selectById(id);
    }

    @Override
    public void deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> findUserByUsername(String user) {
       return userDao.selectByUsername(user);
    }
    
}
