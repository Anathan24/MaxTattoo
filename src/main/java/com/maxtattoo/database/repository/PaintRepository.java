package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PaintRepository extends JpaRepository<Paint, Long> {

    @Query("SELECT p FROM Paint p WHERE p.id=(:paintId)")
    Paint findPaintById(@Param("paintId") Long paintId);

}
