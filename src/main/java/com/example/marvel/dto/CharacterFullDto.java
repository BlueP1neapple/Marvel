package com.example.marvel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Accessors(chain = true)
@Data
public class CharacterFullDto {

    private String name;
    private Set<ComicsDto> comics;
}
