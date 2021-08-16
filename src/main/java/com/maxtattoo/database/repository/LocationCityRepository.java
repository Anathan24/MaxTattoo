package com.maxtattoo.database.repository;

import com.maxtattoo.bean.entity.LocationCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationCityRepository extends JpaRepository<LocationCity, Long> {

    @Query("SELECT lc FROM LocationCity lc WHERE lc.cityIdFk = :cityId")
    List<LocationCity> findAllByCityId(@Param("cityId") Long cityId);

    @Query("SELECT lc FROM LocationCity lc WHERE lc.locationIdFk = :locationId")
    List<LocationCity> findAllByLocationId(@Param("locationId") Long locationId);

}
