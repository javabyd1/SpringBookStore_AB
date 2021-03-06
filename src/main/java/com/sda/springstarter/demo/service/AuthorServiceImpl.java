package com.sda.springstarter.demo.service;


import com.sda.springstarter.demo.exception.AuthorNotFoundException;
import com.sda.springstarter.demo.interfaces.AuthorService;
import com.sda.springstarter.demo.model.Author;
import com.sda.springstarter.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor (Author author) {
        authorRepository.save(author);
    }

    public Author getAuthorByTitle(String name) {
        Optional <Author> author = authorRepository.findAuthorByName(name);
        if (author.isPresent()) {
            return author.get();
        }else {
            throw new AuthorNotFoundException(name);
        }
    }
}