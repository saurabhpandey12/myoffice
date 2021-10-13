package com.fmr.myofficework.util;

import com.fmr.myofficework.domain.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(HibernateUtils.class);

    public static SessionFactory sessionFactory = null;

    static{

        sessionFactory = new Configuration().configure().
                addAnnotatedClass(Work.class).
                addAnnotatedClass(Status.class)
                .addAnnotatedClass(Task.class)
                .addAnnotatedClass(Meetings.class)
                .addAnnotatedClass(Dictionary.class)
                .addAnnotatedClass(TodayLearning.class)
                .addAnnotatedClass(CompletedHistory.class).
                        addAnnotatedClass(DeletedTaskDto.class)
                .buildSessionFactory();
    }

    public static Session getSession(){
        Session session=null;
        try{
            LOGGER.info("Connection Established");
            session = sessionFactory.openSession();
        }catch(Exception e){
            LOGGER.error("Not not established check configuration file");
        }
        return session;
    }

}
