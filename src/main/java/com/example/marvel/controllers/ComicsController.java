package com.example.marvel.controllers;

import com.example.marvel.dto.ComicsFullDto;
import com.example.marvel.models.Comics;
import com.example.marvel.services.ComicsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/public/comics")
@RestController
public class ComicsController {
    @Autowired
    private ComicsServices comicsServices;
    @GetMapping()
    public List<ComicsFullDto> comics(){
        return comicsServices.comicsFindAll();
    }
    @GetMapping("/{comicId}")
    public Comics comicsid(@PathVariable(value = "comicId") String id) throws Exception{
        return comicsServices.comicsFindId(id);
    }
}
