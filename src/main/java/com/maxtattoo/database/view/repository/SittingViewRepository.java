package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.SittingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SittingViewRepository extends JpaRepository<SittingView, Long> {

    @Query("SELECT sv FROM SittingView sv WHERE st.sittingId=(:sittingViewId)")
    SittingView findSittingViewById(@Param("sittingViewId") Long sittingId);
}
