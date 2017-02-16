package com.example.selima.pharmapp.model;

import java.util.List;

/**
 * Created by selim on 16/02/2017.
 */

public class Therapy {
    private int id;
    private int dailyFrequency;
    private int dayFrequency;
    private String startDate;
    private int duration;
    private int stock;
    private int limitStock;
    private boolean notice;
    private boolean suspended;
    private List<Schedule> times;
    private Medicine medicine;

    public Therapy() {
    }

    public Therapy(int id, List<Schedule> times, boolean suspended, boolean notice, int limitStock, int stock,
                   int duration, String startDate, int dayFrequency, int dailyFrequency,  Medicine medicine) {
        this.id = id;
        this.setTimes(times);
        this.suspended = suspended;
        this.notice = notice;
        this.limitStock = limitStock;
        this.stock = stock;
        this.duration = duration;
        this.startDate = startDate;
        this.dayFrequency = dayFrequency;
        this.dailyFrequency = dailyFrequency;
        this.medicine = medicine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDailyFrequency() {
        return dailyFrequency;
    }

    public void setDailyFrequency(int dailyFrequency) {
        this.dailyFrequency = dailyFrequency;
    }

    public int getDayFrequency() {
        return dayFrequency;
    }

    public void setDayFrequency(int dayFrequency) {
        this.dayFrequency = dayFrequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getLimitStock() {
        return limitStock;
    }

    public void setLimitStock(int limitStock) {
        this.limitStock = limitStock;
    }

    public boolean isNotice() {
        return notice;
    }

    public void setNotice(boolean notice) {
        this.notice = notice;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }


    public List<Schedule> getTimes() {
        return times;
    }

    public void setTimes(List<Schedule> times) {
        this.times = times;
    }


    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
