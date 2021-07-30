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
           "WHERE (o.startDate <= :startDate AND o.endDate >= :endDate) AND (:orderType is null or o.orderType.value = :orderType)")
    Integer calculateOrdersTotalNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("orderType") String orderType);

    @Query("SELECT sum(o.orderPrice) " +
           "FROM Order o " +
           "WHERE (o.startDate <= :startDate AND o.endDate >= :endDate) AND (:orderType is null or o.orderType.value = :orderType)")
    Integer calculateOrdersTotalPrice(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("orderType") String orderType);
}
