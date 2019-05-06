/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ft.eLibrary.dao.LoginDAO;
import com.ft.eLibrary.service.LoginService;

/**
 *
 * @author Focus
 */
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private LoginDAO loginDAO;

    @Override
    public int UserLogin(String email, String password) {
        return this.loginDAO.UserLogin(email, password);
    }
    
}
