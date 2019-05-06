/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.mapper;

import com.ft.eLibrary.model.IssueBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Focus
 */
public class IssuedBookRowMapper implements RowMapper<IssueBook>{

    @Override
    public IssueBook mapRow(ResultSet rs, int i) throws SQLException {
        IssueBook ib=new IssueBook();
        ib.setBook_id(rs.getInt("BOOK_ID"));
        ib.setStudent_id(rs.getInt("STUDENT_ID"));
        ib.setStudent_name(rs.getString("STUDENT_NAME"));
        ib.setContact(rs.getLong("CONTACT"));
        return ib;
    }
    
}
