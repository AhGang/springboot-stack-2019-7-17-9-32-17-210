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
    @OneToOne(cascade = CascadeType.ALL)
    private CrimeConstituentInfo crimeConstituentInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Procuratorate procuratorate;
    public Case(String caseName, Long time) {
        this.caseName = caseName;
        this.time = time;
    }

    public Case(String caseName, Long time, CrimeConstituentInfo crimeConstituentInfo) {
        this.caseName = caseName;
        this.time = time;
        this.crimeConstituentInfo = crimeConstituentInfo;
    }

    public Case(String caseName, Long time, CrimeConstituentInfo crimeConstituentInfo, Procuratorate procuratorate) {
        this.caseName = caseName;
        this.time = time;
        this.crimeConstituentInfo = crimeConstituentInfo;
        this.procuratorate = procuratorate;
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
    public CrimeConstituentInfo getCrimeConstituentInfo() {
        return crimeConstituentInfo;
    }

    public void setCrimeConstituentInfo(CrimeConstituentInfo crimeConstituentInfo) {
        this.crimeConstituentInfo = crimeConstituentInfo;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
    public Long getId() {
        return id;
    }
}