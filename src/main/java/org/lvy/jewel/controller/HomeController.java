package org.lvy.jewel.controller;

import com.github.abel533.echarts.Option;
import com.google.common.collect.ImmutableMap;
import org.lvy.jewel.domain.Project;
import org.lvy.jewel.domain.ProjectType;
import org.lvy.jewel.service.IResourceAnalysisResource;
import org.lvy.jewel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
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
        List<ProjectType> projectTypes =
            getResourceAnalysisService().getProjectTypes();
        model.addAttribute("projectTypes", projectTypes);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/projectResources")
    public Option getProjectResources() {
        return getResourceAnalysisService().getProjectResources();
    }

    @ResponseBody
    @RequestMapping(value = "addProject", method = RequestMethod.POST)
    public Map<String,?> addProject(@RequestParam("name") String name,
                                    @RequestParam("type") Integer type,
                                    @RequestParam("deliveryDate") LocalDate deliveryDate) {
        try {
            Project project = new Project();
            project.setDeliveryDate(deliveryDate);
            project.setName(name);
            project.setType(type);
            getResourceAnalysisService().saveProject(project);
            return ImmutableMap.of("success", true);
        } catch (Exception e) {
            return ImmutableMap.of("success", false, "errMsg", "添加失败");
        }
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(Model model) {

        List<Project> projects =
            getResourceAnalysisService().getProjects();
        model.addAttribute("projects", projects);

        return "projects";
    }
}
