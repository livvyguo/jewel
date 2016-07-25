package org.lvy.jewel.controller;

import org.lvy.jewel.domain.User;
import org.lvy.jewel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by livvy on 15/6/27.
 */
@RequestMapping("/")
@Controller
public class HomeController {

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        List<User> allUser = userService.findAllUser();
        System.out.println(allUser);
        model.addAttribute("allUser", allUser);
        return "index";
    }


    @ResponseBody
    @RequestMapping("/getJson")
    public String getJson() {
        return "Json";
    }
}
