/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.dao.impl;

import com.ft.eLibrary.dao.BookDAO;
import com.ft.eLibrary.mapper.BookRowMapper;
import com.ft.eLibrary.mapper.IssuedBookRowMapper;
import com.ft.eLibrary.model.Book;
import com.ft.eLibrary.model.IssueBook;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Focus
 */
@Repository
public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO BOOK VALUES(null,?,?,?,?,null)";
        return this.jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPublisher(), book.getQuantity());

    }

    @Override
    public List<Book> getBooks() {
        String sql = "SELECT * FROM BOOK";
        List<Book> book = this.jdbcTemplate.query(sql, new BookRowMapper());
        return book;
    }

    @Override
    public int validateBook(Book book) {
        String sql = "select count(*) from book where name=?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, book.getName());
    }

    @Override
    public int deleteBook(int book_id) {
        String sql = "DELETE FROM BOOK WHERE BOOK_ID=?";
        return this.jdbcTemplate.update(sql, book_id);
    }

    @Override
    public Book getBookById(int book_id) {
        try {
            String sql = "SELECT * FROM BOOK WHERE BOOK_ID=?";
            return this.jdbcTemplate.queryForObject(sql, new BookRowMapper(), book_id);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public int issueBook(IssueBook ib) {
        String sql = "INSERT INTO ISSUEBOOK VALUES(?,?,?,?)";
        int count = this.jdbcTemplate.update(sql, ib.getBook_id(), ib.getStudent_id(), ib.getStudent_name(), ib.getContact());

        String sql1 = "UPDATE book b SET b.`ISSUED`=b.`ISSUED`+1 WHERE b.`BOOK_ID`=?";
        int count1 = this.jdbcTemplate.update(sql1, ib.getBook_id());

        return count1;
    }

    @Override
    public int getBookQuantity(IssueBook ib) {
        String sql = "SELECT QUANTITY FROM BOOK WHERE BOOK_ID=?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, ib.getBook_id());
    }

    @Override
    public int getBookIssued(IssueBook ib) {
        String sql = "SELECT ISSUED FROM BOOK WHERE BOOK_ID=?";
        return this.jdbcTemplate.queryForObject(sql, Integer.class, ib.getBook_id());
    }

    @Override
    public List<IssueBook> getIssuedBooks() {
        String sql = "SELECT * FROM ISSUEBOOK";
        return this.jdbcTemplate.query(sql, new IssuedBookRowMapper());
    }

    @Override
    public int returnBook(IssueBook ib) {
        String sql = "DELETE FROM ISSUEBOOK WHERE BOOK_ID=? AND STUDENT_ID=?";
        int count1=this.jdbcTemplate.update(sql, ib.getBook_id(), ib.getStudent_id());

        String sql1 = "UPDATE book b SET b.`ISSUED`=b.`ISSUED`-1 WHERE b.`BOOK_ID`=?";
         int count2=this.jdbcTemplate.update(sql1, ib.getBook_id());
        
        return count2;
    }
}
