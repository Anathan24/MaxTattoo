package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.id=(:clientId)")
    Client findClientById(@Param("clientId") Long clientId);

    @Query("SELECT c FROM Client c WHERE c.name=(:name) AND c.surname=(:surname)")
    List<Client> findClientByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("SELECT count(c) FROM Client c")
    int countTotalClientsNumber();

    @Query("SELECT count(c) FROM Client c WHERE c.gender = (:gender)")
    int countTotalClientsNumber(@Param("gender") String gender);

}
