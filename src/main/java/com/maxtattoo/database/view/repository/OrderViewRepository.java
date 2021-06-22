package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderViewRepository extends JpaRepository<OrderView, Long> {

}
