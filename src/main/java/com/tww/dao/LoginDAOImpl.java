package com.tww.dao;

import com.tww.model.TbLogininfo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String Login(TbLogininfo p) {
        String flag = "";
        try {
            Session session = this.sessionFactory.getCurrentSession();
            List list = session.createQuery("from TbLogininfo").list();
            if (list != null) {
                Iterator i = list.iterator();
                while (i.hasNext()) {
                    TbLogininfo info = (TbLogininfo) i.next();
                    if (info.getName().equals(p.getName()) && info.getPassword().equals(p.getPassword())) {
                        flag = "success";
                        break;
                    } else {
                        flag = "error";
                    }
                }
            }
            session.clear();
            System.out.println(flag);
            return flag;
        } catch (HibernateException e) {
            e.printStackTrace();
            return "error";
        }
    }
}