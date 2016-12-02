package org.lvy.jewel.service.impl;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.series.Series;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.lvy.jewel.component.utils.Dates;
import org.lvy.jewel.component.utils.ECharts;
import org.lvy.jewel.domain.InputResource;
import org.lvy.jewel.domain.Project;
import org.lvy.jewel.domain.ProjectType;
import org.lvy.jewel.persistence.InputResourceMapper;
import org.lvy.jewel.persistence.ProjectMapper;
import org.lvy.jewel.persistence.ProjectTypeMapper;
import org.lvy.jewel.service.IResourceAnalysisResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public List<ProjectType> getProjectTypes() {

        return getProjectTypeMapper().selectProjectTypes();
    }

    @Override
    public List<Project> getProjects() {

        List<ProjectType> projectTypes =
            getProjectTypeMapper().selectProjectTypes();

        return getProjectMapper()
            .selectProjects()
            .stream()
            .map(p-> initProject(projectTypes, p))
            .collect(Collectors.toList());
    }

    @Override
    public Option getProjectResources() {

        YearMonth startMonth = YearMonth.now().minusMonths(1);
        YearMonth endMonth = startMonth.plusYears(1);
        List<YearMonth> months = Dates.monthRanges(startMonth, endMonth);
        List<InputResource> inputResources = getInputResourceMapper().selectInputResources();

        List<Project> projects = getProjectMapper().selectProjects();
        List<ProjectType> projectTypes =
            getProjectTypeMapper().selectProjectTypes();

        List<Project> relatedProjects = projects.stream().map(p -> {
            return initProject(projectTypes, p);
        }).filter(p ->
            (
                p.getStartMonth().isAfter(startMonth.minusMonths(1))
                    && p.getStartMonth().isBefore(endMonth.plusMonths(1))
            ) || (
                p.getDeliveryMonth().isAfter(startMonth.minusMonths(1))
                    && p.getDeliveryMonth().isBefore(endMonth.plusMonths(1))
            )
        ).collect(Collectors.toList());

        List<Series> series = relatedProjects.stream().map(p -> {
            List<Integer> data = months.stream().map(m -> {
                if (m.equals(p.getStartMonth())
                    || m.equals(p.getDeliveryMonth())
                    || (m.isAfter(p.getStartMonth()) && m.isBefore(p.getDeliveryMonth()))) {
                    return p.getDuration();
                }
                return 0;
            }).collect(Collectors.toList());
            return ECharts.newBar(p.getName(), "total", data);
        }).collect(Collectors.toList());

        ArrayList<Series> seriesAll = Lists.newArrayList(ECharts.newBar("normal", "total", months
            .stream()
            .map(m ->
                inputResources
                    .stream()
                    .filter(ir -> m.equals(
                        YearMonth.parse(
                            ir.getMonth().toString(),
                            DateTimeFormatter.ofPattern("yyyyMM"))))
                    .map(ir -> ir.getResource())
                    .reduce((x, y) -> x + y)
                    .orElse(0))
            .collect(Collectors.toList())).markPoint(ECharts.newMarkPoint()));
        seriesAll.addAll(series);

        List<String> legends = relatedProjects.stream().map(p -> p.getName()).collect(Collectors
            .toList());
        ArrayList<String> legnedsAll = Lists.newArrayList("normal");
        legnedsAll.addAll(legends);
        List<String> categoryNames = months
            .stream()
            .map(m -> m.format(DateTimeFormatter.ofPattern("yyyy-MM")))
            .collect(Collectors.toList());


        return ECharts.newYValueBarBoard(
            "资源使用情况",
            legnedsAll,
            categoryNames,
            seriesAll);
    }

    @Override
    public void saveProject(Project project) {
        getProjectMapper().addProject(project);

    }

    private Project initProject(List<ProjectType> projectTypes, Project p) {
        Integer type = p.getType();
        ProjectType projectType = Iterables.find(projectTypes, pt -> Objects.equals(pt.getId(), type));
        Integer duration = projectType.getDuration();
        p.setDuration(duration);
        p.setDeliveryMonth(YearMonth.from(p.getDeliveryDate()));
        p.setStartMonth(YearMonth.from(p.getDeliveryDate()).minusMonths(duration));
        return p;
    }

}
