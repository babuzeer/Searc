package com.example.searc.model;
import jakarta.persistence.*;

@Entity
@Table(name = "roads")
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "start_location_id", referencedColumnName = "id")
    private Location startLocation;

    @ManyToOne
    @JoinColumn(name = "end_location_id", referencedColumnName = "id")
    private Location endLocation;

    @Column(nullable = false)
    private Double length;

    @Column(nullable = false)
    private Double congestionLevel;

    // Getters and setters
}
