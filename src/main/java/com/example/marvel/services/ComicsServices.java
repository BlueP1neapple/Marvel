package com.example.marvel.services;

import com.example.marvel.dto.ComicsFullDto;
import com.example.marvel.models.Comics;
import com.example.marvel.repo.ComicsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("comicsService")
public class ComicsServices {
    @Autowired
    private ComicsRepository comicsRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ComicsFullDto> comicsFindAll(){
        List<Comics> comicses = comicsRepository.findAll();

        List<ComicsFullDto> comicsDto = comicses.stream().map(comics -> modelMapper.map(comics, ComicsFullDto.class)).collect(Collectors.toList());

        return comicsDto;
    }

    public Comics comicsAdd(Comics comics) {return comicsRepository.save(comics);}

    public Comics comicsFindId(String id){
        Optional<Comics> comics = comicsRepository.findById(id);
        return comics.get();
    }

}
