package org.lvy.jewel.service;

import com.github.abel533.echarts.Option;
import org.lvy.jewel.domain.Project;
import org.lvy.jewel.domain.ProjectType;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 2016/12/1.
 */
public interface IResourceAnalysisResource {

    List<ProjectType> getProjectTypes();

    List<Project> getProjects();

    Option getProjectResources();

    void saveProject(Project project);

}
