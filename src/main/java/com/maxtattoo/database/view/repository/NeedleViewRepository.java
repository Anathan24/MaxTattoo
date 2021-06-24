package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.NeedleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NeedleViewRepository extends JpaRepository<NeedleView, Long> {

    @Query("SELECT nv FROM NeedleView nv WHERE nv.needleId=(:needleViewId)")
    NeedleView findNeedleViewById(@Param("needleViewId") Long needleViewId);
}
