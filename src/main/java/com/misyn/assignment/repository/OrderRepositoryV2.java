package com.misyn.assignment.repository;

import com.misyn.assignment.entity.OrderDetailsV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryV2 extends JpaRepository<OrderDetailsV2, Long> {
    int deleteOrderDetailsV2ByOrderId(Long orderId);

    OrderDetailsV2 findOrderDetailsV2ByOrderId(Long orderId);
}
