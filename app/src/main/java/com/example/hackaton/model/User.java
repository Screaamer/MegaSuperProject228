package com.example.hackaton.model;

public class User {

    private int id;
    private String name;
    private String lastname;
    private String tname;
    private String birthname;

    public User(int id, String name, String lastname, String tname, String birthname, String sex) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.tname = tname;
        this.birthname = birthname;
        this.sex = sex;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getBirthname() {
        return birthname;
    }

    public void setBirthname(String birthname) {
        this.birthname = birthname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String sex;
    private String image = "1";
}
