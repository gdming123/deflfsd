package com.example.admin.dagger2demo.Bean;

/**
 * Created by admin on 2017/3/30.
 */

public class User {

    private String admin;

    private String passWord;

    public User() {

    }

    public User(String admin, String passWord) {
        this.admin = admin;
        this.passWord = passWord;
    }
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "admin='" + admin + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }


}
