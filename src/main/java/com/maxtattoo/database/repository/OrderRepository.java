package com.maxtattoo.database.repository;

import com.maxtattoo.bean.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.clientId = :clientId")
    List<Order> findAllByClientId(@Param("clientId") Long clientId);

    @Query("SELECT o FROM Order o WHERE o.orderType.id = :orderTypeId")
    List<Order> findAllByOrderTypeId(@Param("orderTypeId") Long orderTypeId);

    @Query("SELECT count(o) " +
           "FROM Order o " +
           "WHERE (o.startDate >= :startDate AND o.endDate <= :endDate) AND (:orderType is null or o.orderType.value = :orderType)")
    Integer calculateOrdersTotalNumber(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("orderType") String orderType);

    @Query("SELECT sum(o.orderPrice) " +
           "FROM Order o " +
           "WHERE (o.startDate >= :startDate AND o.endDate <= :endDate) AND (:orderType is null or o.orderType.value = :orderType)")
    Integer calculateOrdersTotalPrice(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("orderType") String orderType);
}
