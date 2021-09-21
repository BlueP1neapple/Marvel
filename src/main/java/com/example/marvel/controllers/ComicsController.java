package com.example.marvel.controllers;

import com.example.marvel.dto.ComicsFullDto;
import com.example.marvel.models.Comics;
import com.example.marvel.services.ComicsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public Comics comics(@RequestBody Comics comics){
        return comicsServices.comicsAdd(comics);
    }
}
