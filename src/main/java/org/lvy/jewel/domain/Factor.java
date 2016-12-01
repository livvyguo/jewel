package org.lvy.jewel.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/24.
 */
public class Factor {

    private Integer id;
    private Integer funInvestId;
    private String name;
    private BigDecimal scale;

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

    public BigDecimal getScale() {
        return scale;
    }

    public void setScale(BigDecimal scale) {
        this.scale = scale;
    }

    public Integer getFunInvestId() {
        return funInvestId;
    }

    public void setFunInvestId(Integer funInvestId) {
        this.funInvestId = funInvestId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
