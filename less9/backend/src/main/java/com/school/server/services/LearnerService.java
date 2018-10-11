package com.school.server.services;

import com.school.server.models.Grade;
import com.school.server.models.Learner;

import java.util.Optional;

public interface LearnerService {

    void saveLearner(Learner learner);

    Optional<Learner> findLearnerById(Long id);

    Iterable<Learner> findAllLearners();

    void saveGrade(Grade grade);

    void addLearnerToGrade(String gradeName, Learner learner);

    Grade getGradeByName(String gradeName);

}
