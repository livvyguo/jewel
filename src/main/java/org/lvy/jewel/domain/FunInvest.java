package org.lvy.jewel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by livvy (livvyguo@gmail.com) on 16/7/24.
 */
public class FunInvest implements Serializable {

    private Integer id;
    /**
     * 固定的type
     */
    private Integer type;
    /**
     * sys plainer etc.
     */
    private Integer funTeam;
    /**
     * 角色
     */
    private Integer role;
    private BigDecimal preConcept;
    private BigDecimal concept;
    private BigDecimal plan;
    private BigDecimal dev;
    private BigDecimal sdv;
    private BigDecimal sit;
    private BigDecimal svt;
    private Integer valid;

    public Integer getFunTeam() {
        return funTeam;
    }

    public void setFunTeam(Integer funTeam) {
        this.funTeam = funTeam;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public BigDecimal getPreConcept() {
        return preConcept;
    }

    public void setPreConcept(BigDecimal preConcept) {
        this.preConcept = preConcept;
    }

    public BigDecimal getConcept() {
        return concept;
    }

    public void setConcept(BigDecimal concept) {
        this.concept = concept;
    }

    public BigDecimal getPlan() {
        return plan;
    }

    public void setPlan(BigDecimal plan) {
        this.plan = plan;
    }

    public BigDecimal getDev() {
        return dev;
    }

    public void setDev(BigDecimal dev) {
        this.dev = dev;
    }

    public BigDecimal getSdv() {
        return sdv;
    }

    public void setSdv(BigDecimal sdv) {
        this.sdv = sdv;
    }

    public BigDecimal getSit() {
        return sit;
    }

    public void setSit(BigDecimal sit) {
        this.sit = sit;
    }

    public BigDecimal getSvt() {
        return svt;
    }

    public void setSvt(BigDecimal svt) {
        this.svt = svt;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
