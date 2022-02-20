package com.misyn.assignment.service;

import com.misyn.assignment.entity.OrderDetailsV2;

import java.util.List;

public interface OrderServiceV2 {

    List<OrderDetailsV2> getAllOrders() throws Exception;

    OrderDetailsV2 getSelectedOrder(Long orderId) throws Exception;

    OrderDetailsV2 createOrder(OrderDetailsV2 orderDetails) throws Exception;

    OrderDetailsV2 updateOrder(OrderDetailsV2 orderDetails) throws Exception;

    OrderDetailsV2 updateOrderStatus(Long orderId, String orderStatus) throws Exception;

    Boolean deleteOrder(Long orderId) throws Exception;

}
