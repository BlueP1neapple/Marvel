package com.example.marvel.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ElementNotExist extends RuntimeException{
    public ElementNotExist(String name){
        super(name + " dose not exist");
    }
}
