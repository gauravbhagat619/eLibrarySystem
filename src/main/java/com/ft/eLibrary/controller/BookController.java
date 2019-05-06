/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ft.eLibrary.controller;

import com.ft.eLibrary.model.Book;
import com.ft.eLibrary.model.IssueBook;
import com.ft.eLibrary.service.BookService;
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
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String getaddBookPage(ModelMap map) {
        Book book = new Book();
        map.addAttribute("book", book);
        return "/addBook";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String onClickaddBookPage(@ModelAttribute("book") Book book, HttpServletRequest req, ModelMap map) {

        int result = this.bookService.validateBook(book);
        if (result == 0) {
            int count = this.bookService.addBook(book);

            if (count == 1) {
                map.addAttribute("msg", "Book Added Successfully");
                return "addBook";
            } else {
                map.addAttribute("msg", "Book Not Added Successfully");
                return "addBook";
            }
        }
        map.addAttribute("msg", "Book Already Exist");
        return "/addBook";

    }

    @RequestMapping(value = "/listBook", method = RequestMethod.GET)
    public String listBook(ModelMap map) {
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
                    map.addAttribute("msg", "Book Issued Successfully");
                    return "/issueBook";
                } else {
                    map.addAttribute("msg", "Book Not Issued Successfully");
                    return "/issueBook";
                }
            }

        }

    }

    @RequestMapping(value = "/viewIssuedBook", method = RequestMethod.GET)
    public String listIssuedBook(ModelMap map) {
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
        
        System.out.println("IssueBook========="+ib);

        if (book == null) {
            map.addAttribute("msg", "Insert Correct Book Id");
            return "/returnBook";
        } else {
            if (book.getIssued()==0) {
                map.addAttribute("msg", "No Book Available to Return");
                return "/returnBook";
            } else {
                int count = this.bookService.returnBook(ib);
                if (count == 1) {
                    map.addAttribute("msg", "Book Returned Successfully");
                    return "/returnBook";
                } else {
                    map.addAttribute("msg", "Book Not Returned Successfully");
                    return "/returnBook";
                }
            }
        }
    }
}
