package org.lvy.jewel.domain;


import java.util.List;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/25.
 * 项目类型
 */
public class ProjectType {

    private Integer id;
    private String name;
    private String remark;
    private Integer valid;

    private List<FunInvest> funInvests;

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
}
