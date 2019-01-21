package com.anukul.galleryrecyclerview;

public class GalleryModel {
    private String carName;
    private int imgRes;

    public GalleryModel(String carName, int imgRes) {
        this.carName = carName;
        this.imgRes = imgRes;
    }

    public GalleryModel() {

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
