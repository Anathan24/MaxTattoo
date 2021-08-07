package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintRepository extends JpaRepository<Paint, Long> {

}
