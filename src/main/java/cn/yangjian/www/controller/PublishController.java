package cn.yangjian.www.controller;

import cn.yangjian.www.bean.HouseInfo;
import cn.yangjian.www.hibernate.HibernateSession;
import cn.yangjian.www.hibernatebean.Comm;
import cn.yangjian.www.hibernatebean.House;
import cn.yangjian.www.hibernatebean.HouseExt;
import cn.yangjian.www.hibernatebean.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * Created by yangjian on 16-12-31.
 */
@Controller
public class PublishController {
    @Resource
    HibernateSession hibernateSession;

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publishHoush(@ModelAttribute("form") HouseInfo houseInfo, @CookieValue(value = "brokerid", defaultValue = "notlogin") String brokerId) {
        if (null == houseInfo)
            return "publish";
        if (brokerId.equals("notlogin")) {
            return "login";
        }
        Session session = hibernateSession.getSession();
        Logger logger = LoggerFactory.getLogger(PublishController.class);
        House house = null;
        try {
            house = new House();
            Comm comm = new Comm();
            User user = new User();
            HouseExt houseExt = new HouseExt();

            comm.setId(houseInfo.getCommId());
            user.setId(Long.valueOf(brokerId));
            house.setArea(houseInfo.getArea());
            house.setFloor(houseInfo.getFloor());
            house.setHalls(houseInfo.getHalls());
            house.setPrice(houseInfo.getPrice());
            house.setPublishTime(new Timestamp(System.currentTimeMillis() / 1000));
            house.setTotalFloor(houseInfo.getTotalFloor());
            house.setTitle(houseInfo.getTitle());
            house.setRooms(houseInfo.getRooms());
            house.setUser(user);

            houseExt.setHouseDesc(houseInfo.getHouseDesc());
            houseExt.setComm(comm);
            //houseExt.setId(house.getId());
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            session.getTransaction().rollback();
        }

        return "view?houseid=" + house.getId();
    }
}
