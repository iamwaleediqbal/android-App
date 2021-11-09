package com.apps.cyberco2.unfaded.brand.model;

public class SwitchBrand {
    String name;
    int brand, check;

    public SwitchBrand(String name, int brand, int check) {
        this.name = name;
        this.brand = brand;
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
