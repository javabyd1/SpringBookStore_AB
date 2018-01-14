package com.sda.springstarter.demo.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException (String authorName) {
        super ("Could not find Author" + authorName);
    }

}
