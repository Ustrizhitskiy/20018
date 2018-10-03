package com.school.server.services.impl;

import com.school.server.models.Grade;
import com.school.server.repository.GradeRepository;
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

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public void saveLearner(Learner learner) {
        learnerRepository.save(learner);
    }

    @Override
    public Optional<Learner> findLearnerById(Long id) {
        return learnerRepository.findById(id);
    }

    @Override
    public Iterable<Learner> findAllLearners() {
        return learnerRepository.findAll();
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void addLearnerToGrade(String gradeName, Learner learner) {
        Grade gradeByName = gradeRepository.getGradeByName(gradeName);
        learner.setGradeId(gradeByName.getId());
        learnerRepository.save(learner);
    }


    @Override
    public Grade getGradeByName(String gradeName) {
        return gradeRepository.getGradeByName(gradeName);
    }

}
