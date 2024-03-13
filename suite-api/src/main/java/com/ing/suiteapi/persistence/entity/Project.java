package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "project")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "created")
    private LocalDateTime created;

    public Long id() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String createdBy() {
        return createdBy;
    }

    public Project setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LocalDateTime created() {
        return created;
    }

    public Project setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }
}
