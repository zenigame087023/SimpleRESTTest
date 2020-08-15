package com.example.simplerest.model;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    public Department() {}

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    @Column(name="name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
