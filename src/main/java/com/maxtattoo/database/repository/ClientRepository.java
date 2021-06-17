package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.name=(:name) AND c.surname=(:surname)")
    List<Client> findClientByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
