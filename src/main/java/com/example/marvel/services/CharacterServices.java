package com.example.marvel.services;

import com.example.marvel.dto.CharacterFullDto;
import com.example.marvel.dto.ComicsDto;
import com.example.marvel.exeptions.ElementNotExist;
import com.example.marvel.models.Characters;
import com.example.marvel.models.Comics;
import com.example.marvel.repo.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("characterServices")
public class CharacterServices {
    @Autowired
    private CharacterRepository characterRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<CharacterFullDto> characterFindAll(){
        List<Characters> characters = characterRepository.findAll();

        List<CharacterFullDto> characterDto = characters.stream().map(character -> modelMapper.map(character, CharacterFullDto.class)).collect(Collectors.toList());

        return characterDto;
    }

    public Characters characterAdd(Characters character){ return characterRepository.save(character); }

    public Characters characterFindByName(String id){
        return characterRepository.findById(id)
                .orElseThrow(()-> new ElementNotExist(id));
    }
    public List<ComicsDto> comicsByCharacter(String name){
        List<Comics> comics = characterFindByName(name).getComics();
        List<ComicsDto> comicsDtos = new ArrayList<>();
        for(Comics c: comics){
            comicsDtos.add(modelMapper.map(c, ComicsDto.class));
        }
        return comicsDtos;
    }
}
