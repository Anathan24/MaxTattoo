package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.id = (:orderId)")
    Order findOrderById(@Param("orderId") Long orderId);

    @Query("SELECT count(o) FROM Order o")
    Integer calculateTotalOrdersNumber();

    @Query("SELECT count(o) FROM Order o WHERE o.orderType.id = (:orderTypeId)")
    Integer calculateTotalOrdersNumberByOrderTypeTypeId(@Param("orderTypeId") Long orderTypeId);

    @Query("SELECT sum(o.orderPrice) FROM Order o")
    Integer calculateTotalOrdersPrice();

    @Query("SELECT sum(o.orderPrice) FROM Order o WHERE o.orderType.id = (:orderTypeId)")
    Integer calculateTotalOrderPriceByOrderTypeId(@Param("orderTypeId") Long orderTypeId);
}
