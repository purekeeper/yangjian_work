package cn.yangjian.www;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by yangjian on 16-8-26.
 */
@Controller
public class WelcomeController {
    Logger logger = Logger.getLogger(WelcomeController.class);

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
        return "showprofile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(JianGuo jianGuo, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("jianGuo", jianGuo);
       /* model.addAttribute(new JianGuo());*/
        return "redirect:showprofile";
    }

    @RequestMapping(value = "/showprofile", method = RequestMethod.GET)
    public String showProfile(@ModelAttribute("jianGuo") JianGuo jianGuoGuo, Model model) {
      /* // JianGuo jianGuoGuo = (JianGuo) request.getSession().getAttribute("jianGuo");
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        JianGuo jianGuoGuo = (JianGuo) map.get("jianGuo");
        model.addAttribute("jianGuo",jianGuoGuo);*/
        model.addAttribute("name", jianGuoGuo.getName());
        model.addAttribute("age", jianGuoGuo.getAge());
        model.addAttribute("pwd", jianGuoGuo.getPwd());
        model.addAttribute("tel", jianGuoGuo.getTel());
        return "showprofile";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showDefaultPage(Model model) {


      /*  ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("welcome", "你好,坚果!!!!");
        return modelAndView;*/
        //return modelAndView;
        // return "register";
       /* model.addAttribute("welcome","hello jianguo");*/
        return "redirect:register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        JianGuo jianGuo = new JianGuo();
        model.addAttribute("jianGuo", jianGuo);
        return "register";
    }

    private static class JianGuo {
        private String name;
        private String tel;
        private int age;
        private String pwd;

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public JianGuo() {
        }

        public JianGuo(String name, String tel, int age, String pwd) {
            this.name = name;
            this.tel = tel;
            this.age = age;
            this.pwd = pwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
