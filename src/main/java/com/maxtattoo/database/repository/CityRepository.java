package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.cityId=(:cityId)")
    City findCityById(@Param("cityId") Long cityId);

    @Query("SELECT c FROM City c WHERE c.cityName=(:cityName)")
    City findCityByName(@Param("cityName") String cityName);
}
