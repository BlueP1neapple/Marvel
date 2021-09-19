package com.example.marvel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Accessors(chain = true)
@Data
public class ComicsFullDto {
    private String name;
    private Set<Character> characters;
}
