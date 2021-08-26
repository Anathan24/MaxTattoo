package com.maxtattoo.database.repository;

import com.maxtattoo.dto.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c " +
           "FROM Client c " +
           "WHERE c.name = :name AND c.surname= :surname")
    List<Client> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT c FROM Client c WHERE c.name like :initialLetters% or c.surname like :initialLetters%")
    List<Client> findByInitialLetters(@Param("initialLetters") String initialLetters);

    @Query("SELECT COUNT(DISTINCT(c.clientId)) " +
           "FROM Client c INNER JOIN Order o ON c.clientId = o.clientId " +
           "WHERE (o.startDate >= :startDate AND o.endDate <= :endDate) AND (:gender is null or c.gender = :gender)" )
    Integer countTotalClientsNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("gender") String gender);

    @Query("SELECT c FROM Client c WHERE c.location.locationId = :locationId")
    List<Client> findAllByLocationId(@Param("locationId") Long locationId);

}
