package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.ClientView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientViewRepository extends JpaRepository<ClientView, Long> {

    @Query("SELECT cv FROM ClientView cv WHERE cv.clientId=(:clientViewId)")
    ClientView findClientViewById(@Param("clientViewId") Long clientViewId);
}
