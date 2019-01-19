package com.anukul.travelstreamcardview;

public class TravelBeacheModel {
    private String topBeache;
    private String number;
    private String nameOfBeache;
    private String beacheLocation;
    private int travelBeacheImages;

    public TravelBeacheModel(String topBeache, String number, String nameOfBeache, String beacheLocation, int travelBeacheImages) {
        this.topBeache = topBeache;
        this.number = number;
        this.nameOfBeache = nameOfBeache;
        this.beacheLocation = beacheLocation;
        this.travelBeacheImages = travelBeacheImages;
    }

    public TravelBeacheModel() {

    }

    public String getTopBeache() {
        return topBeache;
    }

    public void setTopBeache(String topBeache) {
        this.topBeache = topBeache;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameOfBeache() {
        return nameOfBeache;
    }

    public void setNameOfBeache(String nameOfBeache) {
        this.nameOfBeache = nameOfBeache;
    }

    public String getBeacheLocation() {
        return beacheLocation;
    }

    public void setBeacheLocation(String beacheLocation) {
        this.beacheLocation = beacheLocation;
    }

    public int getTravelBeacheImages() {
        return travelBeacheImages;
    }

    public void setTravelBeacheImages(int travelBeacheImages) {
        this.travelBeacheImages = travelBeacheImages;
    }
}
