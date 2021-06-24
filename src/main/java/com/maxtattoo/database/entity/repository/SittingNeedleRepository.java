package com.maxtattoo.database.entity.repository;

import com.maxtattoo.database.entity.SittingNeedle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SittingNeedleRepository extends JpaRepository<SittingNeedle, Long> {

    @Query("SELECT sn FROM sitting_needle sd WHERE sd.sittingNeedleId=(:sittingNeedleId)")
    SittingNeedle findSittingNeedleById(@Param("sittingNeedleId") Long sittingNeedleId);
}
