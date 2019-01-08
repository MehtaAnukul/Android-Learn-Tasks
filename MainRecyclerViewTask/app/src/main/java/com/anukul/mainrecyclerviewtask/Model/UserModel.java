package com.anukul.mainrecyclerviewtask.Model;

public class UserModel {
    private String nameTv;
    private String dateTv;
    private String details;
    private int userIconImg;
    private int userContentImg;

    public UserModel(String nameTv, String dateTv, String details, int userIconImg, int userContentImg) {
        this.nameTv = nameTv;
        this.dateTv = dateTv;
        this.details = details;
        this.userIconImg = userIconImg;
        this.userContentImg = userContentImg;
    }

    public UserModel(String nameTv, String dateTv, String details) {
        this.nameTv = nameTv;
        this.dateTv = dateTv;
        this.details = details;
    }

    public UserModel() {

    }

    public String getNameTv() {
        return nameTv;
    }

    public void setNameTv(String nameTv) {
        this.nameTv = nameTv;
    }

    public String getDateTv() {
        return dateTv;
    }

    public void setDateTv(String dateTv) {
        this.dateTv = dateTv;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUserIconImg() {
        return userIconImg;
    }

    public void setUserIconImg(int userIconImg) {
        this.userIconImg = userIconImg;
    }

    public int getUserContentImg() {
        return userContentImg;
    }

    public void setUserContentImg(int userContentImg) {
        this.userContentImg = userContentImg;
    }
}
