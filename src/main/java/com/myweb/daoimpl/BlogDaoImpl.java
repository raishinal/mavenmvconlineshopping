/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.daoimpl;

import com.myweb.dao.BlogDao;
import com.myweb.model.Blog;
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
public class BlogDaoImpl implements BlogDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(Blog bl) {
        boolean status=false;
        try( Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(bl);
            session.getTransaction().commit();
            status = true;
        }
        
        return status;
    }

    @Override
    public List<Blog> selectAll() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Blog> mcl  = session.createQuery("from Blog").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Blog> selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Blog where id = :code ");
query.setParameter("code", id);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<Blog> selectByCategory(int category) {
       Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Blog where category = :code ");
query.setParameter("code", category);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public boolean update(Blog bl) {
              boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
           session.beginTransaction();
            session.update(bl);
            session.getTransaction().commit();
            status = true;
           
        }
 return status;
    }

    @Override
    public boolean delete(int id) {
         Blog bl=new Blog();
        bl.setId(id);
        boolean status=false;
 try( Session session = sessionFactory.getCurrentSession()) {
           session.beginTransaction();
            session.delete(bl);
            session.getTransaction().commit();
            session.close();
            status = true;
           
        }
 return status;
    }

    @Override
    public List<Blog> selectByActivation() {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from Blog where status = 1");

List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }
    
}
