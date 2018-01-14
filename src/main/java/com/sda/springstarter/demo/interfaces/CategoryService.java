package com.sda.springstarter.demo.interfaces;

import com.sda.springstarter.demo.model.BookCategory;

import java.util.List;

public interface CategoryService {
    List<BookCategory> getAllCategory ();
    void saveCategory (BookCategory bookCategory);
}
