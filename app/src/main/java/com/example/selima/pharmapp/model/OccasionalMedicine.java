package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class OccasionalMedicine {
    private int id;
    private String name;
    private float amount;
    private String unit;
    private String date;
    private String time;

    public OccasionalMedicine() {
    }

    public OccasionalMedicine(int id, String name, float amount, String unit, String date, String time) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.date = date;
        this.time = time;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
