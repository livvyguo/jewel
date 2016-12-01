package org.lvy.jewel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.time.LocalDate;


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
    private Long type;
    /**
     * 交付日期
     */
    private LocalDate deliveryDate;

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
    public Long getType() {
        return type;
    }
    public void setType(Long type){
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

}
