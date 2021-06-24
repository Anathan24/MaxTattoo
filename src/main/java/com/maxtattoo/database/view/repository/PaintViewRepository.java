package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.PaintView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PaintViewRepository extends JpaRepository<PaintView, Long> {

    @Query("SELECT pv FROM PaintView pv WHERE pv.paintId=(:paintViewId)")
    PaintView findPaintViewById(@Param("paintViewId") Long paintViewId);
}
