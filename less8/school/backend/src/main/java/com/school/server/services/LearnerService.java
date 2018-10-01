package com.school.server.services;

import com.school.server.models.Learner;

import java.util.Optional;

public interface LearnerService {

    void saveLearner(Learner learner);

    Iterable<Learner> findAllLearners();

}
