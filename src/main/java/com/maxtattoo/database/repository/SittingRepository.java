package com.maxtattoo.database.repository;

import com.maxtattoo.bean.entity.Sitting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SittingRepository extends JpaRepository<Sitting, Long> {
}
