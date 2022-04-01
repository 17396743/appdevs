package com.example.appdevs.bean;

/**
 * @创建时间 2022/4/2 1:13
 */
public class CollectDataBean {
    private Integer imges;
    private String name;


    public CollectDataBean(Integer imges, String name) {
        this.imges = imges;
        this.name = name;

    }


    public Integer getImges() {
        return imges;
    }

    public void setImges(Integer imges) {
        this.imges = imges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
