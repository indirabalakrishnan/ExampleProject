package com.app.api.jackson;

import java.util.Date;

public class CarPurchase {
    public Car car;
    public Date dataPurchased;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDataPurchased() {
        return dataPurchased;
    }

    public void setDataPurchased(Date dataPurchased) {
        this.dataPurchased = dataPurchased;
    }

    @Override
    public String toString() {
        return "CarPurchase{" +
                "car=" + car +
                ", dataPurchased=" + dataPurchased +
                '}';
    }
}
