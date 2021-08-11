package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT s FROM State s WHERE s.id= :stateId")
    State findStateById(@Param("stateId") Long stateId);

    @Query("SELECT 1 FROM State s WHERE s.value = :value")
    Integer stateExists(@Param("value") String value);

    @Query("SELECT s FROM State s WHERE s.value = :value")
    State findStateByValue(@Param("value") String value);

}
