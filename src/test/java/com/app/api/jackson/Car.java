package com.app.api.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    public String modelName;
    public int modelNo;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }


    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", modelNo=" + modelNo +
                '}';
    }

}
