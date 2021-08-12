package com.maxtattoo.database.repository;

import com.maxtattoo.pojo.entity.LocationCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationCitiesRepository extends JpaRepository<LocationCities, Long> {
}
