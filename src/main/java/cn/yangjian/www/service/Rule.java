package cn.yangjian.www.service;

import cn.yangjian.www.dao.Dao;
import cn.yangjian.www.hibernatebean.House;
import cn.yangjian.www.hibernatebean.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangjian on 16-12-31.
 */
@Service
public class Rule {
    @Resource
    Dao dao;

    public List<House> filterHouseByArea(int min, int max, int offerset, int pageSize) {
        return dao.filter("area > " + min + " and area <= " + max, offerset, pageSize);
    }

    public List<House> filterHouseByPrice(int min, int max, int offerset, int pageSize) {
        return dao.filter("price > " + min + " and price <= " + max, offerset, pageSize);
    }

    public List<House> filterHouseByRooms(int min, int max, int offerset, int pageSize) {
        return dao.filter("rooms >= " + min + " and rooms <= " + max, offerset, pageSize);
    }

    public List<House> orderHouseByArea(String orderStyle, int offerset, int pageSize) {
        return dao.order("area", orderStyle, offerset, pageSize);
    }

    public List<House> orderHouseByPrice(String orderStyle, int offerset, int pageSize) {
        return dao.order("price", orderStyle, offerset, pageSize);
    }

    public List<House> orderHouseByPublishTime(String orderStyle, int offerset, int pageSize) {
        return dao.order("publishTime", orderStyle, offerset, pageSize);
    }

    public List<User> getUserByAccount(String account, String pwd) {
        return dao.query("account = " + account + " and pwd = " + pwd);
    }
}
