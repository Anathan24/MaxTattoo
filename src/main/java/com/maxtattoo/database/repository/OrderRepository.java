package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT count(o) " +
           "FROM Order o " +
           "WHERE (:orderType is null or o.orderType.value = :orderType) AND (o.startDate <= :startDate AND o.endDate >= :endDate)")
    Integer calculateOrdersTotalNumber(@Param("orderType") String orderType, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT sum(o.orderPrice) " +
           "FROM Order o " +
           "WHERE (:orderType is null or o.orderType.value = :orderType) AND (o.startDate <= :startDate AND o.endDate >= :endDate)")
    Integer calculateOrdersTotalPrice(@Param("orderType") String orderType, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
