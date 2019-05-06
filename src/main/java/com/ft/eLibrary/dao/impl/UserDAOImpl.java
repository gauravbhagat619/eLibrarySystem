/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.dao.impl;

import com.ft.eLibrary.dao.UserDAO;
import com.ft.eLibrary.mapper.UserRowMapper;
import com.ft.eLibrary.model.Librarian;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Focus
 */
@Repository

public class UserDAOImpl implements UserDAO{
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public int addLibrarian(Librarian librarian) {
        PasswordEncoder encoder=new Md5PasswordEncoder();
        String hashPass=encoder.encodePassword(librarian.getPassword(),null);
        String sql="INSERT INTO USER VALUES(null,?,?,?,?)";
        int count=this.jdbcTemplate.update(sql,librarian.getName(),hashPass,librarian.getEmail(),librarian.getMobno());
        return count;
    }

   
    @Override
    public int validateLibrarian(Librarian librarian) {
        String sql="SELECT count(*) FROM user WHERE NAME=?";
        int count = this.jdbcTemplate.queryForObject(sql, Integer.class,librarian.getName());
        return count;
    }

    @Override
    public List<Librarian> getLibrarianList() {
        String sql="select * from user";
        return this.jdbcTemplate.query(sql,new UserRowMapper());
    }

    @Override
    public Librarian getLibrarianById(int user_id) {
        String sql = "select * from user where USER_ID=?";
        return this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), user_id);
    }

    @Override
    public int editLibrarian(Librarian librarian) {
        if(librarian.getPassword().isEmpty()){
            String sql="UPDATE USER SET NAME=?,EMAIL=?,MOBNO=? WHERE USER_ID=?";
            Object []params={librarian.getName(),librarian.getEmail(),librarian.getMobno(),librarian.getUser_id()};
                return this.jdbcTemplate.update(sql,params);
        }
        else{
            String sql="UPDATE USER SET NAME=?,PASSWORD=MD5(?),EMAIL=?,MOBNO=? WHERE USER_ID=?";
            PasswordEncoder encoder=new Md5PasswordEncoder();
            String hashPass=encoder.encodePassword(librarian.getPassword(),null);
            Object []params={librarian.getName(),librarian.getPassword(),librarian.getEmail(),librarian.getMobno(),librarian.getUser_id()};
            return this.jdbcTemplate.update(sql,params);
            
        }
    }

    @Override
    public int deleteLibrarian(int user_id) {
        String sql="DELETE FROM USER WHERE USER_ID=?";
        return this.jdbcTemplate.update(sql,user_id);
    }
}
