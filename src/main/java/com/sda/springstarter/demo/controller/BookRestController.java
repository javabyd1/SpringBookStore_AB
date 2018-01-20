package com.sda.springstarter.demo.controller;

import com.sda.springstarter.demo.model.Author;
import com.sda.springstarter.demo.model.Book;
import com.sda.springstarter.demo.service.AuthorServiceImpl;
import com.sda.springstarter.demo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {


    //Book
    @Autowired
    private BookServiceImpl bookService;

    @CrossOrigin(value = "http://localhost:9999")
    @RequestMapping(value ="book", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @CrossOrigin(value = "http://localhost:9999")
    @RequestMapping(value = "book",method = RequestMethod.POST)
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity <Book> getBookById(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getBookById(id));
    }
    //Authors

    @Autowired
    private AuthorServiceImpl authorService;

    @RequestMapping(value = "author", method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthor();
    }
    @RequestMapping(value = "author", method = RequestMethod.POST)
    public void saveAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }
    @GetMapping(value= "author/{name}")
    public ResponseEntity<Author> getAuthorByTitle(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getAuthorByTitle(name));
    }


}
