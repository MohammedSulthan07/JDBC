package com.hibernate.config;

import com.hibernate.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//import javax.imageio.spi.ServiceRegistry;

public class DataBaseConfig {
    private static final SessionFactory SESSION_FACTORY=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration=new Configuration().addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private DataBaseConfig(){

    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
