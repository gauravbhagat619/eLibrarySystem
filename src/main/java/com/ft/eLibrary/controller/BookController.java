/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;

import cc.altius.utils.POI.POICell;
import cc.altius.utils.POI.POIRow;
import cc.altius.utils.POI.POIWorkSheet;
import com.ft.eLibrary.model.Book;
import com.ft.eLibrary.model.IssueBook;
import com.ft.eLibrary.service.BookService;
import com.google.gson.Gson;
import java.io.OutputStream;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String getaddBookPage(ModelMap map) {
        Book book = new Book();
        map.addAttribute("book", book);
        return "/addBook";
    }

//    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
//    public String onClickaddBookPage(@ModelAttribute("book") Book book, HttpServletRequest req, ModelMap map) {
//
//        int result = this.bookService.validateBook(book);
//        if (result == 0) {
//            int count = this.bookService.addBook(book);
//
//            if (count > 1) {
//                map.addAttribute("msg", "Book Added Successfully");
//                return "redirect:/listBook.htm?msg=" + "Book Added Successfully";
//            } else {
//                map.addAttribute("msg", "Book Not Added Successfully");
//                return "redirect:/listBook.htm?msg=" + "Book Not Added Successfully";
//            }
//        }
//        map.addAttribute("msg", "Book Already Exist");
//        return "/addBook";
//
//    }
//    @RequestMapping(value = "/getViewBookDashboard.htm")
//    public String onSubmitAddBookForm(){
//        return "redirect:/listBook.htm";
//    }
    
    @RequestMapping(value = "/addBookFromAjax.htm")
    @ResponseBody
    public String onSubmitAddBookForm(@RequestParam(value="name")String name,@RequestParam(value="author")String author,@RequestParam(value="publisher")String publisher,@RequestParam(value="quantity")Integer quantity){
        System.out.println(name+' '+author+' '+publisher+' '+quantity);
        Book book = new Book();
        book.setName(name); book.setAuthor(author);book.setPublisher(publisher); book.setQuantity(quantity);
        
        int result = this.bookService.validateBook(book);
        String msg;
        
       if (result == 0) {
            int count = this.bookService.addBook(book);

            if (count > 1) {
                msg="BookAdded";
            } else {
                msg="BookNotAdded";
            }
        }
       else{
           msg="BookExist";
       }
        String json = null;
        Gson gson = new Gson();
        json = gson.toJson(msg);
        System.out.println(json);
        return json;
    }
    

    @RequestMapping(value = "/listBook", method = RequestMethod.GET)
    public String listBook(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        String msg = ServletRequestUtils.getStringParameter(req, "msg");
        map.addAttribute("msg", msg);
        List<Book> book = this.bookService.getBooks();
        map.addAttribute("listBook", book);
        return "/listBook";
    }

    @RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
    public String deleteBook(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        int book_id = ServletRequestUtils.getIntParameter(req, "book_id");

        int result = this.bookService.deleteBook(book_id);

        if (result == 1) {
            map.addAttribute("msg", "Book Deleted Successfully");
            return "redirect:/listBook.htm";
        } else {
            map.addAttribute("msg", "Book Not Deleted Successfully");
            return "redirect:/listBook.htm";
        }
    }

    @RequestMapping(value = "/issueBook", method = RequestMethod.GET)
    public String getIssueBookPage(ModelMap map) {
        IssueBook ib = new IssueBook();
        map.addAttribute("issuebook", ib);
        return "/issueBook";
    }

    @RequestMapping(value = "/issueBook", method = RequestMethod.POST)
    public String onSubmit_IssueBookPage(@ModelAttribute("issuebook") IssueBook ib, HttpServletRequest req, ModelMap map) {

        int book_id = ib.getBook_id();
        System.out.println("===========book_id====" + book_id);

        Book book = this.bookService.getBookById(book_id);

        if (book == null) {
            map.addAttribute("msg", "Please Insert Correct Book Id");
            return "/issueBook";
        } else {
            if (book.getQuantity() == book.getIssued()) {
                map.addAttribute("msg", "Nook Books Available to Issue");
                return "/issueBook";
            } else {
                int count = this.bookService.issueBook(ib);
                if (count == 1) {
                    return "redirect:/viewIssuedBook.htm?msg=" + "Book Issued Successfully";
                } else {
                    return "redirect:/viewIssuedBook.htm?msg=" + "Book Not Issued Successfully";
                }
            }

        }

    }

    @RequestMapping(value = "/viewIssuedBook", method = RequestMethod.GET)
    public String listIssuedBook(HttpServletRequest req, ModelMap map) throws ServletRequestBindingException {
        String msg = ServletRequestUtils.getStringParameter(req, "msg");
        map.addAttribute("msg", msg);
        List<IssueBook> listIssuedBook = this.bookService.getIssuedBooks();
        map.addAttribute("listIssuedBook", listIssuedBook);
        return "/viewIssuedBook";
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String getReturnBookPage(ModelMap map) {
        IssueBook returnBook = new IssueBook();
        map.addAttribute("returnbook", returnBook);
        return "/returnBook";
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String onSubmit_ReturnBookPage(@ModelAttribute("returnbook") IssueBook ib, HttpServletRequest req, ModelMap map) {

        int book_id = ib.getBook_id();
        System.out.println("===========book_id====" + book_id);

        Book book = this.bookService.getBookById(book_id);

        System.out.println("IssueBook=========" + ib);

        if (book == null) {
            map.addAttribute("msg", "Insert Correct Book Id");
            return "/returnBook";
        } else {
            if (book.getIssued() == 0) {
                map.addAttribute("msg", "No Book Available to Return");
                return "/returnBook";
            } else {
                int count = this.bookService.returnBook(ib);
                if (count == 1) {
                    return "redirect:/viewIssuedBook.htm?msg=" + "Book Returned Successfully";
                } else {
                    return "redirect:/viewIssuedBook.htm?msg=" + "Book Not Returned Successfully";
                }
            }
        }

    }

    @RequestMapping(value = "/bookListReport.htm")
    public void getBookListReport(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
        try {
            List<Book> bookList = this.bookService.getBooks();
            OutputStream out = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment;filename=BookList.xls");
            response.setContentType("application/vnd.ms-excel");
            POIWorkSheet mySheet = new POIWorkSheet(out, "BookList");
            mySheet.setPrintTitle(false);
            POIRow headerRow = new POIRow(POIRow.HEADER_ROW);
            headerRow.addCell("Name");
            headerRow.addCell("Author");
            headerRow.addCell("Publisher");
            headerRow.addCell("Quantity");
            headerRow.addCell("Issued");
            mySheet.addRow(headerRow);
            for (Book book : bookList) {
                POIRow dataRow = new POIRow();
                dataRow.addCell(book.getName(), POICell.TYPE_TEXT);
                dataRow.addCell(book.getAuthor(), POICell.TYPE_TEXT);
                dataRow.addCell(book.getPublisher(), POICell.TYPE_TEXT);
                dataRow.addCell(book.getQuantity(), POICell.TYPE_INTEGER);
                dataRow.addCell(book.getIssued(), POICell.TYPE_INTEGER);
                mySheet.addRow(dataRow);
            }
            mySheet.writeWorkBook();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    //this method is for Jquery Ajax
    @RequestMapping(value = "/getBookQuantity.htm")
     @ResponseBody
     public String getBookQuantity(@RequestParam(value = "bookid") int bookid) {
        System.out.println("bookid======="+bookid);
        int quantity = this.bookService.checkBookQuantity(bookid);

        String json = null;
        Gson gson = new Gson();
        json = gson.toJson(quantity);
        return json;
    }
}
