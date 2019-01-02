package com.anukul.profilerecycleview;

public class ProfileModel {
    private String name;
    private String email;
    private int img;

    public ProfileModel(String name, String email, int img) {

        this.name = name;
        this.email = email;
        this.img = img;
    }

    public ProfileModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
