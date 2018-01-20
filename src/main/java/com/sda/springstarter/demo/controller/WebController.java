package com.sda.springstarter.demo.controller;


import com.sda.springstarter.demo.model.Book;
import com.sda.springstarter.demo.service.AuthorServiceImpl;
import com.sda.springstarter.demo.service.BookServiceImpl;
import com.sda.springstarter.demo.service.CategoryServiceImpl;
import com.sda.springstarter.demo.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class WebController {

    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private AuthorServiceImpl authorService;
    @Autowired
    private PublisherServiceImpl publisherService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping(value = "booksList")
    public ModelAndView showBooks() {
        ModelAndView modelBooks = new ModelAndView();
        modelBooks.addObject("books",bookService.getAllBooks());
        modelBooks.addObject("categories", categoryService.getAllCategory());
        modelBooks.addObject("publishers", publisherService.getAllPublisher());
        modelBooks.addObject("book", new Book());
        modelBooks.setViewName("booklist");
        return modelBooks;

    }
    @GetMapping(value = "authorsList")
    public ModelAndView showAuthors() {
        ModelAndView modelAuthor = new ModelAndView();
        modelAuthor.addObject("authors", authorService.getAllAuthor());
        modelAuthor.setViewName("authorlist");
        return modelAuthor;

    }

    @GetMapping(value = "publisherList")
    public ModelAndView showPublisher() {
        ModelAndView modelPublisher = new ModelAndView();
        modelPublisher.addObject("publishers", publisherService.getAllPublisher());
        modelPublisher.setViewName("publisherlist");
        return modelPublisher;
    }
    @PostMapping(value = "addbook")
    public String addBook (@ModelAttribute("book")
                           @Valid Book book,
                           BindingResult bookresult,
                           RedirectAttributes redirectAttributes) {
        bookService.saveBook(book);


        return "redirect:/booksList";
    }
}
