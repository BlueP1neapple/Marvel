package com.example.marvel.controllers;

import com.example.marvel.dto.CharacterFullDto;
import com.example.marvel.models.Characters;
import com.example.marvel.models.Comics;
import com.example.marvel.services.ActionServices;
import com.example.marvel.services.CharacterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/public/characters")
@RestController
public class CharacterController {
    @Autowired
    private CharacterServices characterServices;
    @Autowired
    private ActionServices actionServices;
    @GetMapping()
    public List<CharacterFullDto> character(){
        return characterServices.characterFindAll();
    }
    @GetMapping("/{characterId}")
    public Characters characterFindByName(@PathVariable(value = "characterId") String name){
        return characterServices.characterFindByName(name);
    }
    @PostMapping("/addToComics")
    public void characterToComics(@RequestParam(value = "character", required = false) String characterName,
                                  @RequestParam(value = "comics", required = false) String comicsName) throws Exception {
        actionServices.CharacterAddToComic(characterName, comicsName);
    }
    @PostMapping("/add")
    public Characters addCharacter(@RequestBody Characters characters){
        return characterServices.characterAdd(characters);
    }
}
