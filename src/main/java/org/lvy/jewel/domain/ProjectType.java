package org.lvy.jewel.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/25.
 * 项目类型
 */
public class ProjectType {

    private Integer id;
    private String name;
    private Integer duration;
    private Integer needResources;
    private String remark;
    private Integer valid;

    private List<FunInvest> funInvests;


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNeedResources() {
        return needResources;
    }

    public void setNeedResources(Integer needResources) {
        this.needResources = needResources;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FunInvest> getFunInvests() {
        return funInvests;
    }

    public void setFunInvests(List<FunInvest> funInvests) {
        this.funInvests = funInvests;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
