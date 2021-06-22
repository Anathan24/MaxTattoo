package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.SittingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SittingViewRepository extends JpaRepository<SittingView, Long> {

}
