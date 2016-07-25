package org.lvy.jewel.domain;

import java.util.List;

import java.io.Serializable;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/24.
 */
public class CodeType implements Serializable {
    private Integer type;
    private String name;
    private String remark;
    private Integer valid;

    private List<CodeValue> values;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<CodeValue> getValues() {
        return values;
    }

    public void setValues(List<CodeValue> values) {
        this.values = values;
    }
}
