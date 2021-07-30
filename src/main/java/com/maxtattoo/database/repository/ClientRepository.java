package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Client;
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
    List<Client> findClientByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT COUNT(DISTINCT(c.id)) " +
           "FROM Client c INNER JOIN Order o ON c.id = o.clientId " +
           "WHERE (o.startDate <= :startDate AND o.endDate >= :endDate) AND (:gender is null or c.gender = :gender)" )
    Integer countTotalClientsNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("gender") String gender);

}
