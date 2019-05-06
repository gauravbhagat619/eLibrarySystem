/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;


import com.ft.eLibrary.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Focus
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String getLoginPage(){
        return "/home";
    }
    
    @RequestMapping(value="adminLogin.htm",params="admin",method=RequestMethod.GET)
    public String getAdmin_LoginPage(){
        return "/home";
    }
    
    @RequestMapping(value="adminLogin.htm",params="admin",method=RequestMethod.POST)
    public String onSubmit_Admin_LoginPage(HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
        String email=null,password=null;
        
        
        email=ServletRequestUtils.getStringParameter(req, "email");
        password=ServletRequestUtils.getStringParameter(req,"password");
        
         System.out.println("======================"+email+"======="+password);
        
        int count=this.loginService.UserLogin(email, password);
        System.out.println("======================count"+count);
        if(count==1){
            map.addAttribute("email", email);
            return "/adminPage";
        }
        else{
             map.addAttribute("msg","Incorrect Email or Password");
             return "/home";
            
        }
    }
    
    @RequestMapping(value="librarianLogin.htm",params="libr",method=RequestMethod.POST)
    public String OnSubmit_LibrarianLoginForm(HttpServletRequest req,ModelMap map) throws ServletRequestBindingException{
        String email=null,password=null;
        
        email=ServletRequestUtils.getStringParameter(req, "email");
        password=ServletRequestUtils.getStringParameter(req,"password");
        
        int count=this.loginService.UserLogin(email, password);
        System.out.println("======================count"+count);
        if(count==1){
            
            return "/librarianPage";
        }
        else{
             map.addAttribute("msg","Incorrect Email or Password");
             return "/home";
            
        }
        
        
    }
    
}

