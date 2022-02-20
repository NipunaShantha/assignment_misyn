package com.misyn.assignment.repository;

import com.misyn.assignment.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Long> {
    int deleteOrderDetailsByOrderId(Long orderId);

    OrderDetails findOrderDetailsByOrderId(Long orderId);
}
