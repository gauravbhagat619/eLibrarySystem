/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Gaurav
 */

@Controller
public class SchedularController {
    
    //@Scheduled(cron="*/02 * * * * *")
    public void callingSchedular(){
        System.out.println("Gaurav is Java Developer");
    }
    
}
