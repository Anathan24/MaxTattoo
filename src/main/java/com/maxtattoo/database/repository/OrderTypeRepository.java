package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {

    @Query("SELECT od FROM OrderType od WHERE od.orderTypeId=(:orderTypeId)")
    OrderType findOrderTypeById(@Param("orderTypeId") Long orderTypeId);

    @Query("SELECT od FROM OrderType od WHERE od.type=(:orderTypeName)")
    OrderType findOrderTypeByName(@Param("orderTypeName") String orderTypeName);
}
