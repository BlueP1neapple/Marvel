package com.example.marvel.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ComicsDto {
    String name;
}
