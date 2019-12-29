package com.liveinbits.recyclerviewwithinrecycler;

public class SubModel {
    private int image;
    private String imagetitle;

    public SubModel(int image, String name) {
        this.image = image;
        this.imagetitle = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String name) {
        this.imagetitle = name;
    }
}
