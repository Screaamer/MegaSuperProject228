package com.example.hackaton.model;

public class Banner {
    private String id;
    private String name;
    private String desc;
    private String price;
    private String img;

    public Banner(String id, String name, String desc, String price, String img) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
