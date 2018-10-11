package com.school.server.repository;

import com.school.server.models.Grade;
import com.school.server.models.Learner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GradeRepository extends CrudRepository<Grade, Long> {

    @Query("select g from Grade g where g.gradeName = ?1")
    Grade getGradeByName(String gradeName);

}
