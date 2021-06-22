package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.PaintView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintViewRepository extends JpaRepository<PaintView, Long> {

}
