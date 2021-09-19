package com.example.marvel.controllers;

import com.example.marvel.dto.CharacterFullDto;
import com.example.marvel.repo.CharacterRepository;
import com.example.marvel.services.CharacterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/public/characters")
@RestController
public class CharacterController {
    @Autowired
    private CharacterServices characterServices;
    @GetMapping()
    public List<CharacterFullDto> character(){ return characterServices.characterFindAll();}
    @GetMapping("characterId")
    public Character characterFindByName(@PathVariable(value = "characterId") String name){
        return characterServices.characterFindByName(name);
    }
}
