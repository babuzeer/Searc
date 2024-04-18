package com.example.searc.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeName;
    private String placeClass;
    private Double placeHot;
    private Double placeAssess;
    private Integer placeCx;
    private Integer placeCy;

    @OneToMany(mappedBy = "sourcePlace")//mappedBy属性值指向Road实体中对应的Place属性
    private Set<Road> sourceRoads = new HashSet<>();

    @OneToMany(mappedBy = "destPlace")
    private Set<Road> destRoads = new HashSet<>();
    
    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<InnerPlace> buildings = new HashSet<>();
    
    // getters and setters
}

