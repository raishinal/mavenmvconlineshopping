/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.daoimpl;

import com.itn.dao.BlogDao;
import com.itn.model.Blog;
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
    public void update(Blog bl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
