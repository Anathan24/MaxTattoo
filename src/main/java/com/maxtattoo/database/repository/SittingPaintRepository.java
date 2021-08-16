package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.SittingPaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SittingPaintRepository extends JpaRepository<SittingPaint, Long> {

    @Query("SELECT sp FROM SittingPaint sp WHERE sp.sittingIdFk = :sittingId")
    List<SittingPaint> findAllBySittingId(@Param("sittingId") Long sittingId);

    @Query("SELECT sp FROM SittingPaint sp WHERE sp.paintIdFk = :paintId")
    List<SittingPaint> findAllByPaintId(@Param("paintId") Long paintId);

}
