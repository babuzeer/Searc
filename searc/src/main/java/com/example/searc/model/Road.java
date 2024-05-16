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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getCongestionLevel() {
        return congestionLevel;
    }

    public void setCongestionLevel(Double congestionLevel) {
        this.congestionLevel = congestionLevel;
    }
}
