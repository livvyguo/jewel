package org.lvy.jewel.controller;

import com.google.common.collect.ImmutableMap;
import org.lvy.jewel.service.IResourceAnalysisResource;
import org.lvy.jewel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by livvy on 15/6/27.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @Autowired
    private IResourceAnalysisResource resourceAnalysisService;

    public IResourceAnalysisResource getResourceAnalysisService() {
        return resourceAnalysisService;
    }

    public void setResourceAnalysisService(IResourceAnalysisResource resourceAnalysisService) {
        this.resourceAnalysisService = resourceAnalysisService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "guozheng");
        return "index";
    }


    @ResponseBody
    @RequestMapping("/getJson")
    public Map<String, ?> getJson() {

//        getResourceAnalysisService().test();
        return ImmutableMap.of("success", true);
    }

}
