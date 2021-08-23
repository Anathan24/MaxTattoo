package com.maxtattoo.database.repository;

import com.maxtattoo.dto.entity.SittingNeedle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SittingNeedleRepository extends JpaRepository<SittingNeedle, Long> {

    @Query("SELECT sn FROM SittingNeedle sn WHERE sn.sittingIdFk = :sittingId")
    List<SittingNeedle> findAllBySittingId(@Param("sittingId") Long sittingId);

    @Query("SELECT sn FROM SittingNeedle sn WHERE sn.needleIdFk = :needleId")
    List<SittingNeedle> findAllByNeedleId(@Param("needleId") Long needleId);

}
