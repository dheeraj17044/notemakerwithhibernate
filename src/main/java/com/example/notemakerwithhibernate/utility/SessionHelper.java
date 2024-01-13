package com.example.notemakerwithhibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHelper {

    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        }
        return sessionFactory;
    }
}
