package com.example.searc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double popularity;

    @ManyToOne
    @JoinColumn(name = "internal_map_id", referencedColumnName = "id")
    private InternalMap internalMap;

    // Getters and setters
}
