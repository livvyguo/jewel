package org.lvy.jewel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;


public class Project implements Serializable{

    /**
     * id
     */
    private String id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目类型
     */
    private Integer type;
    /**
     * 交付日期
     */
    private LocalDate deliveryDate;

    private Integer duration;

    private YearMonth deliveryMonth;

    private YearMonth startMonth;

    private Integer needResources;

    public Integer getNeedResources() {
        return needResources;
    }

    public void setNeedResources(Integer needResources) {
        this.needResources = needResources;
    }

    public YearMonth getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(YearMonth startMonth) {
        this.startMonth = startMonth;
    }

    public YearMonth getDeliveryMonth() {
        return deliveryMonth;
    }

    public void setDeliveryMonth(YearMonth deliveryMonth) {
        this.deliveryMonth = deliveryMonth;
    }

    /**
     * id getter & setter
     */
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    /**
     * name getter & setter
     */
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    /**
     * type getter & setter
     */
    public Integer getType() {
        return type;
    }
    public void setType(Integer type){
        this.type = type;
    }

    /**
     * deliveryDate getter & setter
     */
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(LocalDate deliveryDate){
        this.deliveryDate = deliveryDate;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
