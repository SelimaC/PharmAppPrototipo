package com.example.selima.pharmapp.model;

import java.util.List;

/**
 * Created by selim on 16/02/2017.
 */

public class User {
    private String code;
    private String password;
    private List<Therapy> therapies;
    private List<OccasionalMedicine> occasional;

    public User(){
    }

    public User(String code, String password, List<Therapy> therapies, List<OccasionalMedicine> occasional){
        this.setCode(code);
        this.setPassword(password);
        this.setTherapies(therapies);
        this.setOccasional(occasional);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Therapy> getTherapies() {
        return therapies;
    }

    public void setTherapies(List<Therapy> therapies) {
        this.therapies = therapies;
    }


    public List<OccasionalMedicine> getOccasional() {
        return occasional;
    }

    public void setOccasional(List<OccasionalMedicine> occasional) {
        this.occasional = occasional;
    }
}
