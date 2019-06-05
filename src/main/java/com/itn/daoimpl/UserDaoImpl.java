/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.daoimpl;

import com.itn.dao.UserDao;
import com.itn.model.UserDetails;
import com.itn.model.UserLogin;
import com.itn.model.UserRole;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author stim
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired 
    SessionFactory sessionFactory;
    
    
    @Override
    public boolean  insert(UserDetails ud) {
        
       boolean status = false;
        
        UserLogin ul = new UserLogin();
        ul.setUsername(ud.getUserName());
        ul.setPassword(ud.getPassword());
        
        UserRole ur = new UserRole();
        
        
        if(ud.getUserType().equals("User")){
        ul.setActive("1");
        ur.setAuthority("ROLE_USER");
        }
        else{
        ul.setActive("0");
        ur.setAuthority("ROLE_ADMIN");
        }
        
        ud.setUserLogin(ul);
        ud.setUserRole(ur);
        
        // making relation bidirectional
        ul.setUserDetails(ud);
        ur.setUserDetails(ud);
        
        // save userlogin object into database
        try( Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(ud);
            session.getTransaction().commit();
            status = true;
        }
        
        return status;
        
    }

    @Override
    public List<UserDetails> selectAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserDetails> mcl  = session.createQuery("from user_details").list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public List<UserDetails> selectById(int id) {
       Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("from user_details where id = :code ");
query.setParameter("code", id);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> selectByUsername(String user) {
       Session session = sessionFactory.openSession();
        session.beginTransaction(); 
        Query query = session.createQuery("select usr_dtl_id from user_login where username='raishin' ");
//query.setParameter("code", user);
List mcl = query.list();
        session.getTransaction().commit();
        session.close();
        return mcl;
    }

    
    
}
