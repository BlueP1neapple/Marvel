package com.example.marvel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Characters {
    @Id
    private String name;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "character_presence",
            joinColumns = @JoinColumn(name = "comics_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<Comics> comics = new ArrayList<>();

}
