package com.maxtattoo.database.entity.repository;

import com.maxtattoo.database.entity.Sitting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SittingRepository extends JpaRepository<Sitting, Long> {

    @Query("SELECT s FROM Sitting s WHERE s.sittingId=(:sittingId)")
    Sitting findSittingById(@Param("sittingId") Long sittingId);

    @Query("SELECT s FROM Sitting s WHERE s.orderId=(:orderId)")
    List<Sitting> findAllSittingByOrderId(@Param("orderId") Long orderId);
}