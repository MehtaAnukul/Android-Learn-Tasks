package com.anukul.recycleviewcardviewadapter;

public class AirlineModel {

    private String aitlineName;
    private int imgRes;

    public AirlineModel(String aitlineName, int imgRes) {
        this.aitlineName = aitlineName;
        this.imgRes = imgRes;
    }

    public AirlineModel() {
    }

    public String getAitlineName() {
        return aitlineName;
    }

    public void setAitlineName(String aitlineName) {
        this.aitlineName = aitlineName;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
