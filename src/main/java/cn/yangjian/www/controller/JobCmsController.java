package cn.yangjian.www.controller;

import cn.yangjian.www.bean.JobValue;
import cn.yangjian.www.bean.ShowJob;
import cn.yangjian.www.httputil.HttpUtil;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by yangjian on 16-12-27.
 */
@Controller
public class JobCmsController {
    String localUrl = "http://10.249.10.7:8080";
    String requestUrl = "http://10.249.10.7:8060";

    @RequestMapping(value = "/jobcms", method = RequestMethod.GET)
    public String jobcms(String entityId, Model model) {
        List<ShowJob> data = null;
        String url;
        ObjectMapper mapper = new ObjectMapper();
        if (null != entityId) {
            url = requestUrl + "/queryjobbyentityid?entityId=" + entityId + "&bizId=0_1_2_3_4";

        } else {
            url = requestUrl + "/queryjobbybizid?bizId=" + "0_1_2_3_4";
        }
        JSONObject jsonMap = HttpUtil.doHttpGet(url);
        String jsonData = jsonMap.get("data").toString();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, ShowJob.class);
        try {
            data = mapper.readValue(jsonData, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        for (ShowJob showJob : data) {
            i++;
            String ob = "bizId=" + showJob.getJobBizId() + "&entityId=" + showJob.getJobEntityId() + "&executeTime=" + showJob.getExecuteTime();
            showJob.setEditUrl(localUrl + "/editjob?" + ob);
            showJob.setDeleteUrl(localUrl + "/deljob?" + ob);
            showJob.setNo(String.valueOf(i));
        }
        model.addAttribute("jobs", data);
        model.addAttribute("addJobUrl", localUrl + "/addjobpage");
        model.addAttribute("homeUrl", localUrl + "/jobcms");
        return "jobcms";
    }

    @RequestMapping(value = "/jobcmsindex", method = RequestMethod.GET)
    public String jobcmsindex() {
        return "jobcmsindex";
    }

    @RequestMapping(value = "/queryjob", method = RequestMethod.GET)
    public String queryJob(String entityId, RedirectAttributes redirectAttributes) {
       /* //String url = "127.0.0.1:8070/schedule-1.0/queryjob?entityId=" + entityId;
        String url = "127.0.0.1:8060/queryjob?entityId=" + entityId;
        JSONObject jsonMap = HttpUtil.doHttpGet(url);
        List<JobModel> jobs = (List<JobModel>) jsonMap.get("data");
        //  System.out.println(jobs);
        redirectAttributes.addFlashAttribute("jobs", jobs);*/
        return "redirect:jobcms?entityId=" + entityId;
    }

    @RequestMapping(value = "/addjob", method = RequestMethod.POST)
    public String addJob(int bizId, String entityId, String executeTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            Date date = simpleDateFormat.parse(executeTime);
            time = date.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JobValue jobValue = new JobValue(bizId, entityId, time);
        String url = requestUrl + "/setjob";
        HttpUtil.doHttpPost(url, JSONObject.fromObject(jobValue));
        return "redirect:jobcms?entityId=" + entityId;
    }

    @RequestMapping(value = "/addjobpage", method = RequestMethod.GET)
    public String addjobpage(Model model) {
        model.addAttribute("homeUrl", localUrl + "/jobcms");
        return "addjob";
    }

    @RequestMapping(value = "/deljob", method = RequestMethod.GET)
    public String delJob(int bizId, String entityId, long executeTime, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        JobValue jobValue = new JobValue(bizId, entityId, executeTime);
        String url = requestUrl + "/deljob";
        HttpUtil.doHttpPost(url, JSONObject.fromObject(jobValue));
        return "redirect:" + referer;
    }

    //暂不支持此功能
   /* @RequestMapping(value = "/editjob", method = RequestMethod.POST)
    public String editJob(int bizId, String entityId, long executeTime) {
        delJob(bizId, entityId, executeTime);
        addJob(bizId, entityId, executeTime);
        return "jobcms";
    }*/
}
