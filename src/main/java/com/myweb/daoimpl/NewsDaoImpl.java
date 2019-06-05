/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myweb.daoimpl;

import com.myweb.dao.NewsDao;
import com.myweb.model.News;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roslm
 */
@Repository
public class NewsDaoImpl implements NewsDao{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean insert(News bl) {
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
    public List<News> selectAll() {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<News> mcl  = session.createQuery("from News").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<News> selectById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from News where id = :code ");
query.setParameter("code", id);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<News> selectByCategory(int category) {
       Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from News where category = :code ");
query.setParameter("code", category);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public void update(News bl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<News> selectByActivation() {
        Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from News where status = 1");

List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

}
