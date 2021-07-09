package com.maxtattoo.database.repository;

import com.maxtattoo.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.orderId = (:orderId)")
    Order findOrderById(@Param("orderId") Long orderId);

/*    @Query("SELECT o FROM Order o WHERE o.orderType.id = (:orderTypeId)")
    List<Order> findAllOrdersByType(@Param("orderTypeId") Long orderTypeId);*/

}
