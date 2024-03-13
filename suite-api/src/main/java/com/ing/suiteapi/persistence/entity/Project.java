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

    private Project(Builder builder) {
        id = builder.id;
        name = builder.name;
        createdBy = builder.createdBy;
        created = builder.created;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String createdBy;
        private LocalDateTime created;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder createdBy(String val) {
            createdBy = val;
            return this;
        }

        public Builder created(LocalDateTime val) {
            created = val;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
