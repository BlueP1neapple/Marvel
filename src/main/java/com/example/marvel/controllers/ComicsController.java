package com.example.marvel.controllers;

import com.example.marvel.dto.CharacterDto;
import com.example.marvel.dto.ComicsFullDto;
import com.example.marvel.models.Comics;
import com.example.marvel.services.ComicsServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/public/comics")
public class ComicsController {
    @Autowired
    private ComicsServices comicsServices;

    @GetMapping()
    public List<ComicsFullDto> comics(){
        return comicsServices.comicsFindAll();
    }

    @GetMapping("/{comicId}")
    public Comics comicsid(@PathVariable(value = "comicId") String id) throws Exception{
        return comicsServices.comicsFindName(id);
    }

    @GetMapping("/{comicId}/character")
    public List<CharacterDto> CharacterByComics(@PathVariable(value = "comicId") String name){
        List<CharacterDto> list = comicsServices.characterByComics(name);
        return list;
    }

    @PostMapping("/add")
    public Comics comics(@RequestBody Comics comics){
        return comicsServices.comicsAdd(comics);
    }
}
