package com.school.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "learners")
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "grade_name")
    //@Transient
    private String gradeName;

    @Column(name = "grade_id")
    private Long gradeId;

    public Learner() {
    }

    public Learner(String firstName, String lastName, Long gradeId, String gradeName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeId = gradeId;
        this.gradeName = gradeName;

    }

}
