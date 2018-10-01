package com.school.server.services.impl;

import com.school.server.repository.LearnerRepository;
import com.school.server.models.Learner;
import com.school.server.services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LearnerServiceImpl implements LearnerService {

    @Autowired
    LearnerRepository learnerRepository;

    @Override
    public void saveLearner(Learner learner) {
        learnerRepository.save(learner);
    }

    @Override
    public Iterable<Learner> findAllLearners() {
        Iterable<Learner> learners = learnerRepository.findAll();
        return learners;
    }
}
