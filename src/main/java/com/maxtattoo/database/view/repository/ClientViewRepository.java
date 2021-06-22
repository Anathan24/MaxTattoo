package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.ClientView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientViewRepository extends JpaRepository<ClientView, Long> {

}
