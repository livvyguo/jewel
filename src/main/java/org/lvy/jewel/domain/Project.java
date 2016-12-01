package org.lvy.jewel.domain;

import java.io.Serializable;
import java.util.Date;


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
    private Date deliveryDate;

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
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate){
        this.deliveryDate = deliveryDate;
    }

}
