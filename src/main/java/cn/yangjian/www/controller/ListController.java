package cn.yangjian.www.controller;

import cn.yangjian.www.bean.ListHouse;
import cn.yangjian.www.hibernatebean.House;
import cn.yangjian.www.service.Rule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjian on 16-12-31.
 */
@Controller
public class ListController {
    @Value("work.web.baseurl")
    String baseUrl;
    @Resource
    Rule rule;
    private static final int PAGE_SIZE = 60;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(int page, int min, int max, int ruleId, String orderStyle, Model model) {
        List<House> houseList = null;
        int offerset = (page > 0 ? page - 1 : 0) * PAGE_SIZE;
        switch (ruleId) {
            case 1: {//价格筛选
                houseList = rule.filterHouseByPrice(min, max, offerset, PAGE_SIZE);
            }
            break;
            case 2: {//面积筛选
                houseList = rule.filterHouseByArea(min, max, offerset, PAGE_SIZE);
            }
            break;
            case 3: {//户型筛选
                houseList = rule.filterHouseByRooms(min, max, offerset, PAGE_SIZE);
            }
            break;
            case 4: {//面积排序
                houseList = rule.orderHouseByArea(orderStyle, offerset, PAGE_SIZE);
            }
            break;
            case 5: {//价格排序
                houseList = rule.orderHouseByPrice(orderStyle, offerset, PAGE_SIZE);
            }
            break;
            case 6: {//发布时间排序
                houseList = rule.orderHouseByPublishTime(orderStyle, offerset, PAGE_SIZE);
            }
            break;
        }
        List<ListHouse> listHouses = new ArrayList<>();
        for (House house : houseList) {
            ListHouse listHouse = new ListHouse(
                    house.getTitle(),
                    house.getArea(),
                    house.getRooms(),
                    house.getHalls(),
                    house.getPrice(),
                    house.getFloor(),
                    house.getTotalFloor(),
                    house.getUser().getName());
            listHouse.setUrl(baseUrl + "/view?id=" + house.getId());
            listHouses.add(listHouse);
        }
        model.addAttribute("houses", listHouses);
        model.addAttribute("loginUrl", baseUrl + "/login");
        model.addAttribute("publishUrl", baseUrl + "/publish");
        return "list";
    }
}
