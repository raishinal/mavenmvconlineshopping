/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.daoimpl;

import com.myweb.dao.ProductDao;
import com.myweb.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raishin
 */

@Repository
public class ProductDaoImpl implements ProductDao {
 @Autowired
    SessionFactory sessionFactory;
    @Override
    public boolean insert(Product pro) {
        boolean status=false;
        try( Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(pro);
            session.getTransaction().commit();
            status = true;
        }
        
        return status;
    }

    @Override
    public List<Product> selectAll() {
       Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> mcl  = session.createQuery("from Product").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Product> selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Product where id = :code ");
query.setParameter("code", id);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(Product pro) {
         boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
           session.beginTransaction();
            session.update(pro);
            session.getTransaction().commit();
            status = true;
           
        }
 return status;
    }
    
    
    
    

    @Override
    public boolean delete(int id) {
        boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
             Query query = session.createQuery("delete from Product where id = :code ");
query.setParameter("code", id);
int result = query.executeUpdate();
            session.getTransaction().commit();
            status = true;
           
        }
 return status;
    }

    @Override
    public List<Product> selectByCategory(int category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Product where category = :code ");
query.setParameter("code", category);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Product> selectByTags(String tag) {
       Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Product where tags = :code ");
query.setParameter("code",tag);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    }
    

