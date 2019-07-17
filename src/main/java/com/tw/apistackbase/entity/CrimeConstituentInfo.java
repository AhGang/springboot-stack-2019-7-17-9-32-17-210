package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CrimeConstituentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 255)
    private String subjectiveRequirement;
    @Column(nullable = false,length = 255)
    private String objectiveRequirement;

    public CrimeConstituentInfo(String subjectiveRequirement, String objectiveRequirement) {
        this.subjectiveRequirement = subjectiveRequirement;
        this.objectiveRequirement = objectiveRequirement;
    }

    public String getSubjectiveRequirement() {
        return subjectiveRequirement;
    }

    public void setSubjectiveRequirement(String subjectiveRequirement) {
        this.subjectiveRequirement = subjectiveRequirement;
    }

    public String getObjectiveRequirement() {
        return objectiveRequirement;
    }

    public void setObjectiveRequirement(String objectiveRequirement) {
        this.objectiveRequirement = objectiveRequirement;
    }
}
