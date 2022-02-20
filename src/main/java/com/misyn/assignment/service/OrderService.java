package com.misyn.assignment.service;

import com.misyn.assignment.entity.OrderDetails;

import java.util.List;

public interface OrderService {

    List<OrderDetails> getAllOrders() throws Exception;

    OrderDetails getSelectedOrder(Long orderId) throws Exception;

    OrderDetails createOrder(OrderDetails orderDetails) throws Exception;

    OrderDetails updateOrder(OrderDetails orderDetails) throws Exception;

    OrderDetails updateOrderStatus(Long orderId, String orderStatus) throws Exception;

    Boolean deleteOrder(Long orderId) throws Exception;

}
