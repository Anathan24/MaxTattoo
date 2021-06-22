package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.NeedleView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedleViewRepository extends JpaRepository<NeedleView, Long> {

}
