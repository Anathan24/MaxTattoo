package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.SittingNeedle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SittingNeedleRepository extends JpaRepository<SittingNeedle, Long> {

    @Query("SELECT sn FROM SittingNeedle sn WHERE sn.sittingNeedleId=(:sittingNeedleId)")
    SittingNeedle findSittingNeedleById(@Param("sittingNeedleId") Long sittingNeedleId);
}
