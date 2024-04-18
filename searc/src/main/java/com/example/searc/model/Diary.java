package com.example.searc.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diaryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User diaryAuthor; // 注意这里已经从String类型变为User类型

    @Lob
    private String diaryBody;
    private Double diaryHot;
    private Double diaryAssess;
    private String diaryTag;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate; // 注意这里使用了java.util.Date

    // 省略了getters和setters以及构造方法
}