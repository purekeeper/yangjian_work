package cn.yangjian.www.dao;

import cn.yangjian.www.hibernate.HibernateSession;
import cn.yangjian.www.hibernatebean.House;
import cn.yangjian.www.hibernatebean.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangjian on 16-12-31.
 */
@Repository
public class Dao {
    @Resource
    HibernateSession hibernateSession;

    public List<House> filter(String condition, int offerset, int pageSize) {
        Session session = hibernateSession.getSession();
        Query q = session.createQuery("From House where " + condition);
        q.setFirstResult(offerset);
        q.setMaxResults(pageSize);
        return q.list();
    }

    public List<House> order(String field, String orderStyle, int offerset, int pageSize) {
        Session session = hibernateSession.getSession();
        Query q = session.createQuery("From House Order by " + field + " " + orderStyle);
        q.setFirstResult(offerset);
        q.setMaxResults(pageSize);
        return q.list();
    }

    public List<User> query(String condition) {
        Session session = hibernateSession.getSession();
        Query q = session.createQuery("From User " + condition);
        return q.list();
    }

}
