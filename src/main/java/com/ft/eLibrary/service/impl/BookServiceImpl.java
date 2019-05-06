/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.service.impl;

import com.ft.eLibrary.dao.BookDAO;
import com.ft.eLibrary.model.Book;
import com.ft.eLibrary.model.IssueBook;
import com.ft.eLibrary.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Focus
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public int addBook(Book book) {
        return this.bookDAO.addBook(book);
    }

    @Override
    public List<Book> getBooks() {
        return this.bookDAO.getBooks();
    }

    @Override
    public int validateBook(Book book) {
       return this.bookDAO.validateBook(book);
    }

    @Override
    public int deleteBook(int book_id) {
       return this.bookDAO.deleteBook(book_id);
    }

    @Override
    public Book getBookById(int book_id) {
        return this.bookDAO.getBookById(book_id);
    }

    @Override
    public int issueBook(IssueBook ib) {
        return this.bookDAO.issueBook(ib);
    }

    

    @Override
    public int getBookQuantity(IssueBook ib) {
        return this.bookDAO.getBookQuantity(ib);
    }

    @Override
    public int getBookIssued(IssueBook ib) {
        return this.bookDAO.getBookIssued(ib);
    }

    @Override
    public List<IssueBook> getIssuedBooks() {
       return this.bookDAO.getIssuedBooks();
    }

    @Override
    public int returnBook(IssueBook ib) {
        return this.bookDAO.returnBook(ib);
    }

    
}
