/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.model;

/**
 *
 * @author Focus
 */
public class Librarian {

    private int user_id;
    private String name;
    private String email;
    private String password;
    private Long mobno;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobno() {
        return mobno;
    }

    public void setMobno(Long mobno) {
        this.mobno = mobno;
    }

    @Override
    public String toString() {
        return "Librarian{" + "user_id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobno=" + mobno + '}';
    }

}
