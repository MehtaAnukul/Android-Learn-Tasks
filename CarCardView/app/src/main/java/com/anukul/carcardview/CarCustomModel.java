package com.anukul.carcardview;

import android.widget.TextView;

public class CarCustomModel {
    private String carName;
    private String carPrice;

    public CarCustomModel(String carName, String carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
    }

    public CarCustomModel() {

    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}
