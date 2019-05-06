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
public class IssueBook {

    private Integer book_id;
    private Integer student_id;
    private String student_name;
    private Long contact;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "IssueBook{" + "book_id=" + book_id + ", student_id=" + student_id + ", student_name=" + student_name + ", contact=" + contact + '}';
    }

}
