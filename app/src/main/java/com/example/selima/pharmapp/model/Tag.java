package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class Tag {
    private String id;
    private String name;
    private String colour;
    private String batteryLevel;
    private Integer teraphy;
    private String user;

    public Tag() {
    }

    public Tag(String id, String name, String colour, String batteryLevel, String user, Integer teraphy) {
        this.setId(id);
        this.setName(name);
        this.setColour(colour);
        this.setBatteryLevel(batteryLevel);
        this.setUser(user);
        this.setTeraphy(teraphy);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(String batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Integer getTeraphy() {
        return teraphy;
    }

    public void setTeraphy(Integer teraphy) {
        this.teraphy = teraphy;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public boolean isAssociate(){
        return (teraphy==null && user==null);
    }
}
