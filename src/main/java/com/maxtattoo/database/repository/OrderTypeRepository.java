package com.maxtattoo.database.repository;

import com.maxtattoo.dto.entity.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {

    @Query("SELECT 1 FROM OrderType od WHERE od.value = :value")
    Integer orderTypeExistsByValue(@Param("value") String value);

    @Query("SELECT od FROM OrderType od WHERE od.value = :value")
    OrderType findOrderTypeByValue(@Param("value") String value);

}
