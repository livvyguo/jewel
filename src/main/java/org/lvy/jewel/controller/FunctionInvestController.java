package org.lvy.jewel.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/23.
 */
@Controller
@RequestMapping(value = "funcInvest")
public class FunctionInvestController {

    @ResponseBody
    @RequestMapping("getJson")
    public Map<String,?> getJson() {
        return ImmutableMap.of("success", true);
    }

}
