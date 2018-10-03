package com.school.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "name")
    private String gradeName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gradeId", cascade = CascadeType.ALL)   // имя поля в классе Learner
    private List<Learner> learners = new ArrayList<>();

    public Grade() {
    }

    public Grade(String name) {
        this.gradeName = name;
        //learners = null;
    }

    public void addLearnerToGrade(Learner learner) {
        learners.add(learner);
    }

}
