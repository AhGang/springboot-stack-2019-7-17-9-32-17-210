package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 255)
    private String caseName;
    @Column(nullable = false)
    private Long time;

    public Case(String caseName, Long time) {
        this.caseName = caseName;
        this.time = time;
    }


    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}