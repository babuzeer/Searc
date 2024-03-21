// 文件路径: src/main/java/com/example/searc/model/School.java
package com.example.searc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String type; // e.g., "Primary", "Secondary", "University"
    private Integer rating;

    // Standard getters and setters
}
