package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.LocationCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCityRepository extends JpaRepository<LocationCity, Long> {

}
