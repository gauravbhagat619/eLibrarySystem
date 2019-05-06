/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.service.impl;

import com.ft.eLibrary.dao.UserDAO;
import com.ft.eLibrary.mapper.UserRowMapper;
import com.ft.eLibrary.model.Librarian;
import com.ft.eLibrary.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Focus
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public int addLibrarian(Librarian librarian) {
        return this.userDAO.addLibrarian(librarian);
    }

    @Override
    public int validateLibrarian(Librarian librarian) {
        return this.userDAO.validateLibrarian(librarian);
    }

    @Override
    public List<Librarian> getLibrarianList() {
       return this.userDAO.getLibrarianList();
    }

    @Override
    public Librarian getLibrarianById(int user_id) {
        return this.userDAO.getLibrarianById(user_id);
    }

    @Override
    public int editLibrarian(Librarian librarian) {
        return this.userDAO.editLibrarian(librarian);
    }

    @Override
    public int deleteLibrarian(int user_id) {
        return this.userDAO.deleteLibrarian(user_id);
    }
    
}
