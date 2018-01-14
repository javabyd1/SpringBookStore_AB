package com.sda.springstarter.demo.service;

import com.sda.springstarter.demo.interfaces.CategoryService;
import com.sda.springstarter.demo.model.BookCategory;
import com.sda.springstarter.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<BookCategory> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory (BookCategory bookCategory) {
        categoryRepository.save(bookCategory);
    }
}
