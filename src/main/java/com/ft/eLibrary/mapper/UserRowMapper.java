/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.mapper;

import com.ft.eLibrary.model.Librarian;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Focus
 */
public class UserRowMapper implements RowMapper<Librarian>{

    @Override
    public Librarian mapRow(ResultSet rs, int i) throws SQLException {
        Librarian librarian=new Librarian();
        librarian.setUser_id(rs.getInt("USER_ID"));
        librarian.setName(rs.getString("NAME"));
        librarian.setEmail(rs.getString("EMAIL"));
        //librarian.setPassword(rs.getString("PASSWORD"));
        librarian.setMobno(rs.getLong("MOBNO"));
        return librarian;
    }
}
