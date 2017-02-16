package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class Assumption {
    private int id;
    private String date;
    private boolean presa;
    private int delay;
    private int humor;
    private float pain;
    private String notes;

    public Assumption() {
    }

    public Assumption(int id, String notes, float pain, int humor, int delay, boolean presa, String date) {
        this.setId(id);
        this.setNotes(notes);
        this.setPain(pain);
        this.setHumor(humor);
        this.setDelay(delay);
        this.setPresa(presa);
        this.setDate(date);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPresa() {
        return presa;
    }

    public void setPresa(boolean presa) {
        this.presa = presa;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        this.humor = humor;
    }

    public float getPain() {
        return pain;
    }

    public void setPain(float pain) {
        this.pain = pain;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
