package com.sda.springstarter.demo.controler;

import com.sda.springstarter.demo.model.Book;
import com.sda.springstarter.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestControler {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @RequestMapping( method = RequestMethod.POST)
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @GetMapping(value = "{id}")
    public  Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }



}
