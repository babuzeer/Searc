package com.example.searc.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "innerplace")
public class InnerPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String innerplaceName;
    private String innerplaceClass;

    @ManyToOne
    @JoinColumn(name = "place_id") // 关联到Place实体的外键
    private Place place;

        // 假设InnerPlace是路的起点
    @OneToMany(mappedBy = "sourceInnerPlace")
    private Set<Road> originatingRoads = new HashSet<>();

    // 假设InnerPlace是路的终点
    @OneToMany(mappedBy = "destinationInnerPlace")
    private Set<Road> terminatingRoads = new HashSet<>();

    // getters and setters
}