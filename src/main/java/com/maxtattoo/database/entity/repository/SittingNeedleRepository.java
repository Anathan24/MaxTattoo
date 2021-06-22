package com.maxtattoo.database.entity.repository;

import com.maxtattoo.database.entity.SittingNeedle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SittingNeedleRepository extends JpaRepository<SittingNeedle, Long> {

    @Query("SELECT sn FROM SittingNeedle sn WHERE sn.sittingId=(:sittingId)")
    List<SittingNeedle> findSittingNeedleBySittingId(@Param("sittingId") Long sittingId);
}
