package com.jpa_flyway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @Column(name = "modify_at",nullable = false)
    private LocalDateTime modifyAt;

    @PrePersist
    private void onCreate(){
        createAt = LocalDateTime.now();
        modifyAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate(){
        modifyAt = LocalDateTime.now();
    }
}
