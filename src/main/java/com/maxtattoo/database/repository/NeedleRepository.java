package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.Needle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeedleRepository extends JpaRepository<Needle, Long> {

}
