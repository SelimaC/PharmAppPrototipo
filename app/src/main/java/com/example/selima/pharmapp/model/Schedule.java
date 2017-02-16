package com.example.selima.pharmapp.model;

import java.util.List;

/**
 * Created by selim on 16/02/2017.
 */

public class Schedule {
    private String time;
    private float amount;
    private int therapy;
    private List<Assumption> taken;

    public Schedule() {
    }

    public Schedule(String time, float amount, int therapy,  List<Assumption> taken) {
        this.setTime(time);
        this.setAmount(amount);
        this.setTherapy(therapy);
        this.setTaken(taken);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTherapy() {
        return therapy;
    }

    public void setTherapy(int therapy) {
        this.therapy = therapy;
    }


    public List<Assumption> getTaken() {
        return taken;
    }

    public void setTaken(List<Assumption> taken) {
        this.taken = taken;
    }
}
