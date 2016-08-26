package cn.yangjian.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yangjian on 16-8-26.
 */
@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(Model model) {

      /*  System.out.println(hello);*/
       /*  ModelAndView model = new ModelAndView();
        //设置返回视图名称
        model.setViewName("hello");
        //传值,规则同上
        model.addObject("hello","world1");
        //传值,规则同上
        model.addObject("world2");*/
        //        这样放参数的话,在jsp中直接用EL访问hello即可
        model.addAttribute("hello", "你好坚果!!!");
//        这样方参数的话,默认的key是参数类型
        return "hellojianguo";
    }
}
