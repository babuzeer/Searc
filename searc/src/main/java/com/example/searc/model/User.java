package com.example.searc.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String username;

    @Column(nullable = false, length = 64) // 密码长度可能要更长，特别是当它们是散列值时
    private String userPassword;

    @OneToMany(mappedBy = "diaryAuthor")
    private Set<Diary> diaries = new HashSet<>();
    // 省略了getters和setters
}
