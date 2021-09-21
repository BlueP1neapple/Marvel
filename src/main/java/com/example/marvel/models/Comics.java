package com.example.marvel.models;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Comics {
    @Id
    private String name;

    @ManyToMany
    @JoinTable(
            name = "character_presence",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "comics_id"))
    private List<Characters> character = new ArrayList<>();


}
