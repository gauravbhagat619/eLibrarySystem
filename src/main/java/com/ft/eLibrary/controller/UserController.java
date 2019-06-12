/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;

import cc.altius.utils.POI.POICell;
import cc.altius.utils.POI.POIRow;
import cc.altius.utils.POI.POIWorkSheet;
import com.ft.eLibrary.model.District;
import com.ft.eLibrary.model.Librarian;
import com.ft.eLibrary.model.State;
import com.ft.eLibrary.model.Student;
import com.ft.eLibrary.model.Village;
import com.ft.eLibrary.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Focus
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addLibrarian", method = RequestMethod.GET)
    public String getAdd_Librarian_Page(ModelMap map) {
        Librarian librarian = new Librarian();
        map.addAttribute("librarian", librarian);
        return "/addLibrarian";
    }

    @RequestMapping(value = "/addLibrarian", method = RequestMethod.POST)
    public String onClick_AddLibrarian_Page(@ModelAttribute("librarian") Librarian librarian, HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {

        int count = this.userService.validateLibrarian(librarian);
        if (count == 0) {
            int count2 = this.userService.addLibrarian(librarian);

            if (count2 == 1) {
                return "redirect:/listLibrarian.htm?msg=" + "Librarian Added Successfully";
            } else {
                map.addAttribute("msg", " Not Added Successfully");
                return "/addLibrarian";
            }
        } else {
            map.addAttribute("msg", "Librarian Already Exist");
            return "/addLibrarian";
        }
    }

    @RequestMapping(value = "/listLibrarian", method = RequestMethod.GET)
    public String getListLibrarianPage(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        List<Librarian> librarianList = this.userService.getLibrarianList();
        String msg = ServletRequestUtils.getStringParameter(req, "msg");
        map.addAttribute("msg", msg);
        map.addAttribute("libList", librarianList);
        return "/listLibrarian";
    }

    @RequestMapping(value = "/editLibrarian", method = RequestMethod.GET)
    public String getEditLibrarianPage(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        int user_id = ServletRequestUtils.getIntParameter(req, "user_id");
        System.out.println("==============user_id " + user_id);

        Librarian libr = this.userService.getLibrarianById(user_id);
        System.out.println("==============libr" + libr);
        map.addAttribute("libr", libr);
        return "/editLibrarian";
    }

    @RequestMapping(value = "/editLibrarian", method = RequestMethod.POST)
    public String onClick_EditLibrarianPage(@ModelAttribute("libr") Librarian libr, HttpServletRequest req, ModelMap map) {
        System.out.println("librarian================" + libr);
        int count = this.userService.editLibrarian(libr);

        System.out.println("===============================count" + count);

        if (count == 1) {
            map.addAttribute("msg", "Information Updated Successfully");
            return "redirect:/listLibrarian.htm";
        } else {
            map.addAttribute("msg", "Information Not updated Successfully");
            return "redirect:/listLibrarian.htm";
        }
    }

    @RequestMapping(value = "/deleteLibrarian", method = RequestMethod.GET)
    public String deleteLibrarian(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        int user_id = ServletRequestUtils.getIntParameter(req, "user_id");

        int result = this.userService.deleteLibrarian(user_id);

        if (result == 1) {
            return "redirect:/listLibrarian.htm?msg=" + "Librarian Deleted Successfully";
        } else {
            map.addAttribute("msg", "Error in Deleting Librarian");
            return "redirect:/listLibrarian.htm";
        }
    }

    @RequestMapping(value = "/librarianListReport.htm")
    public void getLibrarianListReport(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        try {
            List<Librarian> librarianList = this.userService.getLibrarianList();
            OutputStream out = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=LibrarianList.xls");
            response.setContentType("application/vnd.ms-excel");
            POIWorkSheet mySheet = new POIWorkSheet(out, "LibrarianList");
            mySheet.setPrintTitle(false);
            POIRow headerRow = new POIRow(POIRow.HEADER_ROW);
            headerRow.addCell("User Id");
            headerRow.addCell("User Name");
            headerRow.addCell("Email");
            headerRow.addCell("Mobile Number");
            mySheet.addRow(headerRow);
            for (Librarian librarian : librarianList) {
                POIRow dataRow = new POIRow();
                dataRow.addCell(librarian.getUser_id(), POICell.TYPE_INTEGER);
                dataRow.addCell(librarian.getName(), POICell.TYPE_TEXT);
                dataRow.addCell(librarian.getEmail(), POICell.TYPE_TEXT);
                dataRow.addCell(librarian.getMobno(), POICell.TYPE_TEXT);
                mySheet.addRow(dataRow);
            }
            mySheet.writeWorkBook();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addStudent.htm", method = RequestMethod.GET)
    public String getAddStudentPage(ModelMap map) {
        Student student = new Student();

        List<State> stateList = this.userService.getStateList();
        List<District> districtList = this.userService.getDistrictList();
        
        map.addAttribute("student", student);
        map.addAttribute("stateList", stateList);
        map.addAttribute("districtList", districtList);
        return "/addStudent";
    }

    @RequestMapping(value = "/addStudent.htm", method = RequestMethod.POST)
    public String onClickAddStudentPage(@ModelAttribute("student") Student student, ModelMap map) {
        System.out.println("Student==========="+student);
        int result = this.userService.addStudent(student);

        if (result > 0) {
            map.addAttribute("msg", "Student Added Successfully");
            return "redirect:/viewStudent.htm";
        }
        map.addAttribute("msg", "Error in Adding Student");
        return "redirect:/viewStudent.htm";
    }

    @RequestMapping(value = "/getDistrictListByStateId.htm")
    public @ResponseBody
    String getDistrictListByStateId(@RequestParam(value = "stateid") int stateid) {
        System.out.println("=====stateid======"+stateid);
        List<District> districtList = this.userService.getListOfDistrict_By_StateId(stateid);

        Gson gson = new Gson();
        Type typeList = new TypeToken<List<District>>() {
        }.getType();
        return gson.toJson(districtList, typeList);
    }
    
    @RequestMapping(value = "/getVillageListByDistrictId.htm")
    public @ResponseBody
    String getVillageListByDistrictId(@RequestParam(value = "districtid") int districtid) {
        System.out.println("=====villageid======"+districtid);
        List<Village> villageList = this.userService.getListOfVillage_By_DistrictId(districtid);

        Gson gson = new Gson();
        Type typeList = new TypeToken<List<District>>() {
        }.getType();
        return gson.toJson(villageList, typeList);
    }
    
    @RequestMapping(value = "/viewStudent", method = RequestMethod.GET)
    public String viewBook(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        String msg = ServletRequestUtils.getStringParameter(req, "msg");
        map.addAttribute("msg", msg);
        List<Student> studentList = this.userService.getStudentList();
        map.addAttribute("listStudent", studentList);
        return "/viewStudent";
    }

}
