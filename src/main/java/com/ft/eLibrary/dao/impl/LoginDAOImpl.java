/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.dao.impl;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ft.eLibrary.dao.LoginDAO;

/**
 *
 * @author Focus
 */
@Repository
public class LoginDAOImpl implements LoginDAO{
    
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    

    @Override
    public int UserLogin(String email, String password) {
        String sql="select count(*) from user where email=? and password=MD5(?)";
        int count=this.jdbcTemplate.queryForObject(sql,Integer.class,email,password);
        return count;
    }

    
    
}
