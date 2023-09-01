package com.apprendre.myproject.entity;


import jakarta.persistence.*;

@Table(name = "student")
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "niveau", nullable = false)
    private String niveau;


    public StudentEntity() {
    }

    public StudentEntity(Long id, String name, String email, String niveau) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.niveau = niveau;
    }

    public StudentEntity(String name, String email, String niveau) {
        this.name = name;
        this.email = email;
        this.niveau = niveau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}
