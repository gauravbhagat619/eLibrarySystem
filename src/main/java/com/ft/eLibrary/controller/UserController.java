/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;

import com.ft.eLibrary.dao.UserDAO;
import com.ft.eLibrary.model.Librarian;
import com.ft.eLibrary.service.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Focus
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/addLibrarian",method=RequestMethod.GET)
    public String getAdd_Librarian_Page(ModelMap map){
        Librarian librarian=new Librarian();
        map.addAttribute("librarian",librarian);
        return "/addLibrarian";
    }
    
    @RequestMapping(value="/addLibrarian",method=RequestMethod.POST)
    public String onClick_AddLibrarian_Page(@ModelAttribute("librarian") Librarian librarian,HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
       
        
        int count=this.userService.validateLibrarian(librarian);
        
       if(count==0){
           int count2=this.userService.addLibrarian(librarian);
           
           
           
           if(count2==1){
               return "redirect:/listLibrarian.htm?msg="+"Librarian Added Successfully";
           }
           else{
                map.addAttribute("msg"," Not Added Successfully");
                return "/addLibrarian";
            }
       }
       else{
           map.addAttribute("msg","Librarian Already Exist");
               return "/addLibrarian"; 
       }
    }
    
    @RequestMapping(value="/listLibrarian",method=RequestMethod.GET)
    public String getListLibrarianPage(HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
        List<Librarian> librarianList=this.userService.getLibrarianList();
        String msg=ServletRequestUtils.getStringParameter(req,"msg");
        map.addAttribute("msg", msg);
        map.addAttribute("libList", librarianList);
        return "/listLibrarian";
    }
    
    @RequestMapping(value="/editLibrarian",method=RequestMethod.GET)
    public String getEditLibrarianPage(HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
        int user_id=ServletRequestUtils.getIntParameter(req, "user_id");
        System.out.println("==============user_id "+user_id);
        
        Librarian libr=this.userService.getLibrarianById(user_id);
        System.out.println("==============libr"+libr);
        map.addAttribute("libr",libr);
        return "/editLibrarian";
    }
    
    @RequestMapping(value="/editLibrarian",method=RequestMethod.POST)
    public String onClick_EditLibrarianPage(@ModelAttribute("libr") Librarian libr,HttpServletRequest req,ModelMap map){
        System.out.println("librarian================"+libr);
        int count=this.userService.editLibrarian(libr);
        
        System.out.println("===============================count"+count);
        
        if(count==1){
            map.addAttribute("msg","Information Updated Successfully");
            return "redirect:/listLibrarian.htm";
        }
        else{
            map.addAttribute("msg","Information Not updated Successfully");
            return "redirect:/listLibrarian.htm";
        }
    }
    
    @RequestMapping(value="/deleteLibrarian",method=RequestMethod.GET)
    public String deleteLibrarian(HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
        int user_id=ServletRequestUtils.getIntParameter(req,"user_id");
        
        int result=this.userService.deleteLibrarian(user_id);
        
        if(result==1){
            return "redirect:/listLibrarian.htm?msg="+"Librarian Deleted Successfully";
        }
        else{
            map.addAttribute("msg","Error in Deleting Librarian");
            return "redirect:/listLibrarian.htm";
        }
    }
}
