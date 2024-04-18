package com.example.searc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roadDistance;
    private Double roadCrowd;
    
    @ManyToOne
    @JoinColumn(name = "source_place_id")
    private Place sourcePlace;

    @ManyToOne
    @JoinColumn(name = "dest_place_id")
    private Place destPlace;

    @ManyToOne
    @JoinColumn(name = "source_innerplace_id")
    private InnerPlace sourceInnerPlace;

    @ManyToOne
    @JoinColumn(name = "dest_innerplace_id")
    private InnerPlace destinationInnerPlace;
    // getters and setters
}
