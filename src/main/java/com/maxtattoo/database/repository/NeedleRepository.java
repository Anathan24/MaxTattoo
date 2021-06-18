package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Needle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface NeedleRepository extends JpaRepository<Needle, Long> {

    @Query("SELECT n FROM Needle n WHERE n.needleId=(:needleId)")
    Needle findNeedleById(@Param("needleId") Long needleId);

}
