package com.apps.cyberco2.unfaded.brand.model;

public class CollectionModel {
    String name, address, price, rating;
    int image;
    boolean checked;

    public CollectionModel(String name, String address, String price, String rating, int image, boolean checked) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.checked = checked;
    }

    public CollectionModel(String name, String address, String price, String rating, int image) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.image = image;
    }

    public CollectionModel(String name, String address, String price, int image) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
