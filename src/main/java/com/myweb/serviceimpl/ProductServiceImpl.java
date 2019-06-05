/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.serviceimpl;

import com.myweb.dao.ProductDao;
import com.myweb.model.Product;
import com.myweb.service.ProductService;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

       
    private String uploadDir = "C:\\Users\\roslm\\OneDrive\\Documents\\NetBeansProjects\\mavenwebapp\\src\\main\\webapp\\resources";
    
    @Autowired
    private ProductDao productDao;
    
    @Override
    public boolean uploadImage(MultipartFile image) {
        boolean status = false;
        
        File dir = new File(uploadDir + File.separator + "productimage");
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
    public boolean addProduct(Product pro) {
        return productDao.insert(pro);
       
    }

    @Override
    public List<Product> findAllProduct() {
         return productDao.selectAll();
    }

    @Override
    public List<Product> findProductById(int id) {
         return productDao.selectById(id);
    }

    @Override
    public boolean updateProduct(Product pro) {
       return productDao.update(pro);
    }

    @Override
    public boolean deleteProduct(int id) {
       return productDao.delete(id);
    }

    @Override
    public List<Product> findProductByCategory(int category) {
             return productDao.selectByCategory(category);
    }

    @Override
    public List<Product> findProductByTags(String tag) {
         return productDao.selectByTags(tag);
    }


    
    
}
