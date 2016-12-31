package cn.yangjian.www.controller;

import cn.yangjian.www.hibernatebean.User;
import cn.yangjian.www.service.Rule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yangjian on 16-12-31.
 */
@Controller
public class LoginController {
    @Resource
    Rule rule;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String account, String pwd, HttpServletResponse response) {
        String gopage;
        List<User> list = rule.getUserByAccount(account, pwd);
        if (list.isEmpty()) {
            gopage = "login";
        } else {
            gopage = "redirect:list";
            response.addCookie(new Cookie("brokerid", String.valueOf(list.get(0).getId())));
        }
        return gopage;

    }
}
