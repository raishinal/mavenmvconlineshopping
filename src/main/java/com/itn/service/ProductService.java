/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.service;

import com.itn.model.Product;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Raishin
 */
public interface ProductService {
    public boolean addProduct(Product pro);
    
    public List<Product> findAllProduct();
        
    public List<Product> findProductById(int id);
    public List<Product> findProductByCategory(int category);
    public List<Product> findProductByTags(String tag);
   
    
    public boolean updateProduct(Product pro);
    
    public boolean deleteProduct(int id);
    boolean uploadImage(MultipartFile image);
}
