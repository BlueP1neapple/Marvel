package com.example.marvel.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Character {
    @Id
    private String name;


    @ManyToMany
    @JoinTable(
            name = "character_presence",
            joinColumns = @JoinColumn(name = "comics_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Set<Comics> comics = new HashSet<>();

}
