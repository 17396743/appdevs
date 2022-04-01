package com.example.appdevs.bean;

/**
 * @创建时间 2022/4/1 23:21
 */
public class MyListBean {
    private Integer imges;
    private String name;


    public MyListBean(Integer imges, String name) {
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
