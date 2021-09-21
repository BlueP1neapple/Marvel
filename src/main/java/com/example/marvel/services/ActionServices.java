package com.example.marvel.services;

import com.example.marvel.models.Characters;
import com.example.marvel.models.Comics;
import com.example.marvel.repo.CharacterRepository;
import com.example.marvel.repo.ComicsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServices {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ComicsRepository comicsRepository;
    public void CharacterAddToComic(String character_name, String comics_name) throws Exception{
        Characters character = characterRepository.findById(character_name).orElseThrow(()-> new NotFoundException("Character not found"));
        Comics comics = comicsRepository.findById(comics_name).orElseThrow(()-> new NotFoundException("Comics not found"));
        character.getComics().add(comics);
        characterRepository.save(character);

    }
}
