package org.lvy.jewel.service.impl;

import org.lvy.jewel.domain.InputResource;
import org.lvy.jewel.domain.Project;
import org.lvy.jewel.domain.ProjectType;
import org.lvy.jewel.persistence.InputResourceMapper;
import org.lvy.jewel.persistence.ProjectMapper;
import org.lvy.jewel.persistence.ProjectTypeMapper;
import org.lvy.jewel.service.IResourceAnalysisResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 2016/12/1.
 */
@Service
public class ResourceAnalysisService implements IResourceAnalysisResource {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectTypeMapper projectTypeMapper;

    @Autowired
    private InputResourceMapper inputResourceMapper;

    public ProjectMapper getProjectMapper() {
        return projectMapper;
    }

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public ProjectTypeMapper getProjectTypeMapper() {
        return projectTypeMapper;
    }

    public void setProjectTypeMapper(ProjectTypeMapper projectTypeMapper) {
        this.projectTypeMapper = projectTypeMapper;
    }

    public InputResourceMapper getInputResourceMapper() {
        return inputResourceMapper;
    }

    public void setInputResourceMapper(InputResourceMapper inputResourceMapper) {
        this.inputResourceMapper = inputResourceMapper;
    }

    @Override
    public void test() {
        List<Project> projects = getProjectMapper().selectProjects();
        List<InputResource> resources = getInputResourceMapper().selectInputResources();
        List<ProjectType> projectTypes = getProjectTypeMapper().selectProjectTypes();
        System.out.println("");
    }
}
