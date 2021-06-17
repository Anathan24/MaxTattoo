package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PaintRepository extends JpaRepository<Paint, Long> {

    @Query("SELECT p FROM Paint p WHERE p.paintId=(:paintId)")
    Paint findPaintById(@Param("paintId") Long paintId);

    @Query("SELECT p FROM Paint p WHERE p.producer=(:producer)")
    List<Paint> findAllPaintsByProducer(@Param("producer") String producer);

    @Query("SELECT p FROM Paint p WHERE p.color=(:color)")
    List<Paint> findPaintByColor(@Param("color") String color);
}
