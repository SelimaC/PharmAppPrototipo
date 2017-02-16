package com.example.selima.pharmapp.model;

/**
 * Created by selim on 16/02/2017.
 */

public class User {
    private String code;
    private String password;

    public User(){
    }

    public User(String code, String password){
        this.setCode(code);
        this.setPassword(password);
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
}
