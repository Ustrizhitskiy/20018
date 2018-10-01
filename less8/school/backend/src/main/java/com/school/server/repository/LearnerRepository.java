package com.school.server.repository;

import com.school.server.models.Learner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public interface LearnerRepository extends CrudRepository<Learner, Long> {

}
