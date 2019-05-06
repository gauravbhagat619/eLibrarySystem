/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.mapper;

import com.ft.eLibrary.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Focus
 */
public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book book=new Book();
        book.setBook_id(rs.getInt("BOOK_ID"));
        book.setName(rs.getString("NAME"));
        book.setAuthor(rs.getString("AUTHOR"));
        book.setPublisher(rs.getString("PUBLISHER"));
        book.setQuantity(rs.getInt("QUANTITY"));
        book.setIssued(rs.getInt("ISSUED"));
        return book;
    }
}
