package com.maxtattoo.database.entity.repository;

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

    @Query("SELECT sp FROM sitting_paint sp WHERE sp.sitting_paintId=(:sittingPaintId)")
    SittingPaint findBySittingPaintId(@Param("sittingPaintId") Long sittingPaint);
}
