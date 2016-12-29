package cn.yangjian.www.controller;

import cn.yangjian.www.bean.MachineLoadInfo;
import cn.yangjian.www.httputil.HttpUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yangjian on 16-12-21.
 */
@Controller
public class UserDashBoardController {

    @RequestMapping(value = "/timerservicemonitor", method = RequestMethod.GET)
    public String dashPage(Model model) {
        JSONObject jsonMap = HttpUtil.doHttpGet("http://127.0.0.1:8070/schedule-1.0/machineinfo");
        List<MachineLoadInfo> machines = (List<MachineLoadInfo>) jsonMap.get("data");
        model.addAttribute("machines", machines);
        return "timerservicemonitor";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectToIndex(Model model) {
      /*  ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("welcome", "你好,坚果!!!!");
        return modelAndView;*/
        //return modelAndView;
        // return "register";
       /* model.addAttribute("welcome","hello jianguo");*/
        //return "timer";
        // return "timer";
        //return "redirect:timerservicemonitor";
        return "redirect:jobcms";
    }

}
