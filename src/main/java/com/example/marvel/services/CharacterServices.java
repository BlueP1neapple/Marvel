package com.example.marvel.services;

import com.example.marvel.dto.CharacterFullDto;
import com.example.marvel.models.Characters;
import com.example.marvel.repo.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<Characters> character = characterRepository.findById(id); // справить, рекурсию
        return character.get();
    }
}
