package cn.yangjian.www.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by yangjian on 16-12-31.
 */
@Component
public class HibernateSession {
    Configuration cfg;
    SessionFactory factory;
    Session session;

    //建立SessionFactory
    public HibernateSession() {
        cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
        session = factory.openSession();
    }

    @PostConstruct
    public void init() {
        session.beginTransaction();
    }

    @PreDestroy
    public void destroy() {
        if (session != null) {
            if (session.isOpen()) {
                //关闭session
                session.close();
            }
        }
    }

    public Session getSession() {
        return session;
    }
}
