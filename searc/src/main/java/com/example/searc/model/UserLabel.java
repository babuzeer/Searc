package com.example.searc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_label")
public class UserLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Label label;

    // 省略了getters和setters
}