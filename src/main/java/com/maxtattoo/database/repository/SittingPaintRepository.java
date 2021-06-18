package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.SittingPaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SittingPaintRepository extends JpaRepository<SittingPaint, Long> {

    @Query("SELECT sp FROM SittingPaint sp WHERE sp.sittingPaintId=(:sittingPaintId)")
    SittingPaint findSittingPaintById(@Param("sittingPaintId") Long sittingPaintId);

    @Query("SELECT sp FROM SittingPaint sp WHERE sp.sittingId=(:sittingId)")
    List<SittingPaint> findSittingPaintBySittingId(@Param("sittingId") Long sittingId);
}
