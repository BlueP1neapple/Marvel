package com.example.marvel.dto;

import lombok.Data;


import java.util.List;

@Data
public class CharacterFullDto {

    private String name;
    private List<ComicsDto> comics;
}
