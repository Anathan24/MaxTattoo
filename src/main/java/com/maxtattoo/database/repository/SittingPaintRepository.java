package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.SittingPaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SittingPaintRepository extends JpaRepository<SittingPaint, Long> {

    @Query("SELECT sp FROM SittingPaint sp WHERE sp.id=(:sittingPaintId)")
    SittingPaint findBySittingPaintId(@Param("sittingPaintId") Long sittingPaint);
}
