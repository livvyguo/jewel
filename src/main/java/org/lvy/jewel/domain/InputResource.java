package org.lvy.jewel.domain;

import java.io.Serializable;

public class InputResource implements Serializable{

    /**
     * id
     */
    private String id;
    /**
     * 资源月份
     */
    private Integer month;
    /**
     * 资源数量
     */
    private Integer resource;

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
     * month getter & setter
     */
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month){
        this.month = month;
    }

    /**
     * resource getter & setter
     */
    public Integer getResource() {
        return resource;
    }
    public void setResource(Integer resource){
        this.resource = resource;
    }

}
