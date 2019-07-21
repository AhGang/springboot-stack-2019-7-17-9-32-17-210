package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Prosecutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 255)
    private String Name;

    public Prosecutor(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public Long getId() {
        return id;
    }

}
