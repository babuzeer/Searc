package com.example.searc.model;

import jakarta.persistence.*;
@Entity
@Table(name = "place_label")
public class PlaceLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    // 省略了getters和setters
}