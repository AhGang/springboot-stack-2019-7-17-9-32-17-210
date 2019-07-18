package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 255)
    private String Name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_prosecutor")
    private List<Prosecutor> prosecutors;
    public Procuratorate(String name, List<Prosecutor> prosecutors) {
        Name = name;
        this.prosecutors = prosecutors;
    }

    public List<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(List<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }

    public Procuratorate(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
