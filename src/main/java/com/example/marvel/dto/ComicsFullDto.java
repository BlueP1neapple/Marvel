package com.example.marvel.dto;

import lombok.Data;


import java.util.List;

@Data
public class ComicsFullDto {
    private String name;
    private List<Character> characters;
}
