/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.dao;

import com.ft.eLibrary.model.Librarian;
import java.util.List;

/**
 *
 * @author Focus
 */
public interface UserDAO {
    
    public int addLibrarian(Librarian librarian);
    
   public List<Librarian> getLibrarianList();
    
    public int validateLibrarian(Librarian librarian);
    
    public Librarian getLibrarianById(int user_id);
    
    public int editLibrarian(Librarian librarian);
    
    public int deleteLibrarian(int user_id);
}
