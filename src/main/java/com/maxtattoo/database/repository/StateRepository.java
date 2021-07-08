package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT s FROM State s WHERE s.stateId=(:stateId)")
    State findStateById(@Param("stateId") Long stateId);

}
