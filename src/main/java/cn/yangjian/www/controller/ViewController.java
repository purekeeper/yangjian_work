package cn.yangjian.www.controller;

import cn.yangjian.www.bean.ViewHouse;
import cn.yangjian.www.hibernate.HibernateSession;
import cn.yangjian.www.hibernatebean.House;
import cn.yangjian.www.hibernatebean.HouseExt;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by yangjian on 16-12-31.
 */
@Controller
public class ViewController {
    @Resource
    HibernateSession hibernateSession;
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(int id, Model model) {
        Session session=hibernateSession.getSession();
        House house=session.get(House.class,id);
        HouseExt houseExt=session.get(HouseExt.class,id);
        ViewHouse viewHouse=new ViewHouse(
                house.getId(),
                house.getTitle(),
                house.getArea(),
                house.getRooms(),
                house.getHalls(),
                house.getPrice(),
                house.getFloor(),
                house.getTotalFloor(),
                house.getUser().getName(),
                houseExt.getHouseDesc(),
                house.getPublishTime().getTime(),
                houseExt.getComm().getBuildYear(),
                houseExt.getComm().getCommName(),
                houseExt.getComm().getCommAddr()
        );
        model.addAttribute("house",viewHouse);
        return "view";
    }
}
