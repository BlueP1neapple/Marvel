package com.example.marvel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

//@Accessors(chain = true)
@Data
public class ComicsFullDto {
    private String name;
    private List<Character> characters;
}
