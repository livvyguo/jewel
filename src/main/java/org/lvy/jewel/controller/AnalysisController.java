package org.lvy.jewel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by livvy (livvyguo@gmail.com) on 2016/12/1.
 */
@Controller
@RequestMapping("analysis")
public class AnalysisController {


    @RequestMapping("/")
    public String index(){
        return "analysis/index";
    }
}
