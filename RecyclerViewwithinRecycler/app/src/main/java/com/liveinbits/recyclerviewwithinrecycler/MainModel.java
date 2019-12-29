package com.liveinbits.recyclerviewwithinrecycler;

import java.util.List;

public class MainModel {
    private String title;
    private List<SubModel> subModelList;

    public MainModel(String title, List<SubModel> subModelList) {
        this.title = title;
        this.subModelList = subModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public List<SubModel> getSubModelList() {
        return subModelList;
    }

    public void setSubModelList(List<SubModel> subModelList) {
        this.subModelList = subModelList;
    }
}
