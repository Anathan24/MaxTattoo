package com.maxtattoo.database.entity.repository;

import com.maxtattoo.database.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    @Query("SELECT co FROM ClientOrder co WHERE co.clientOrderId=(:clientOrderId)")
    ClientOrder findClientOrderById(@Param("clientOrderId") Long clientOrderId);
}
