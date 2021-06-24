package com.maxtattoo.database.view.repository;

import com.maxtattoo.database.view.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderViewRepository extends JpaRepository<OrderView, Long> {

    @Query("SELECT ov FROM OrderView ov WHERE ov.orderId=(:orderViewId)")
    OrderView findOrderViewById(@Param("orderViewId")Long orderViewId);
}
