package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.NeedleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedleViewRepository extends JpaRepository<NeedleView, Long> {

    @Query("SELECT nv FROM NeedleView nv WHERE nv.needleId=(:needleViewId)")
    NeedleView findNeedleViewById(@Param("needleVIewID") Long needleViewId);
}
