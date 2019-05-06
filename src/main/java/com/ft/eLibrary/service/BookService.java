/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.service;

import com.ft.eLibrary.model.Book;
import com.ft.eLibrary.model.IssueBook;
import java.util.List;

/**
 *
 * @author Focus
 */
public interface BookService {
    public int addBook(Book book);
    
    public List<Book> getBooks();
    
    public List<IssueBook> getIssuedBooks();
    
    public int validateBook(Book book);
    
     public int deleteBook(int book_id);
     
     public Book getBookById(int book_id);
     
     public int issueBook(IssueBook ib);
     
    
     
     public int getBookQuantity(IssueBook ib);
     
     public int getBookIssued(IssueBook ib);
     
     public int returnBook(IssueBook ib);
     
     
}
