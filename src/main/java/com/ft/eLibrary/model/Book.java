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
public class Book {
    private int book_id;
    private String name;
    private String author;
    private String publisher;
    private Integer quantity;
    private int issued;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    } 

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    @Override
    public String toString() {
        return "Book{" + "book_id=" + book_id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", quantity=" + quantity + ", issued=" + issued + '}';
    }

    
    
    
}
