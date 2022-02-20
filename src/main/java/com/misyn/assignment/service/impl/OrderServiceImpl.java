package com.misyn.assignment.service.impl;

import com.misyn.assignment.entity.OrderDetails;
import com.misyn.assignment.enums.OrderStatus;
import com.misyn.assignment.repository.OrderRepository;
import com.misyn.assignment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProducerService producerService;

    @Transactional
    @Override
    public List<OrderDetails> getAllOrders() throws Exception {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public OrderDetails getSelectedOrder(Long orderId) throws Exception {
        try {
            if (null != orderId && orderId > 0) {
                return orderRepository.findOrderDetailsByOrderId(orderId);
            } else {
                throw new Exception("Id cannot be null or unavailable");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public OrderDetails createOrder(OrderDetails orderDetails) throws Exception {
        try {
            if (null == orderDetails.getOrderId()) {
                orderDetails = orderRepository.save(orderDetails);
                producerService.publishTopic(orderDetails.getCourierCompany().getCompanyCode());
            }
            return orderDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public OrderDetails updateOrder(OrderDetails orderDetails) throws Exception {
        try {
            if (null != orderDetails.getOrderId() && orderDetails.getOrderId() > 0) {
                OrderDetails existingOrder = orderRepository.findOrderDetailsByOrderId(orderDetails.getOrderId());
                if (existingOrder.getRecordStatus() == OrderStatus.PLACED) {
                    orderDetails = orderRepository.save(orderDetails);
                    producerService.publishTopic(orderDetails.getCourierCompany().getCompanyCode());
                } else {
                    throw new Exception("Order Cannot Be Changed");
                }
            }
            return orderDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    @Override
    public OrderDetails updateOrderStatus(Long orderId, String orderStatus) throws Exception {
        try {
            if (null != orderId && orderId > 0) {
                OrderDetails orderDetails = orderRepository.findOrderDetailsByOrderId(orderId);
                if (Objects.equals(orderStatus, OrderStatus.DELIVERED.toString())) {
                    orderDetails.setRecordStatus(OrderStatus.DELIVERED);
                    return orderRepository.save(orderDetails);
                } else if (Objects.equals(orderStatus, OrderStatus.PICKED.toString())) {
                    orderDetails.setRecordStatus(OrderStatus.PICKED);
                    return orderRepository.save(orderDetails);
                } else {
                    throw new Exception("Undefined order status");
                }
            } else {
                throw new Exception("Id cannot be null or unavailable");
            }
        } catch (Exception e) {
            throw e;
        }
    }


    @Transactional
    @Override
    public Boolean deleteOrder(Long orderId) throws Exception {
        try {
            int status = 0;
            if (null != orderId && orderId > 0) {
                status = orderRepository.deleteOrderDetailsByOrderId(orderId);
                return status > 0;
            } else {
                throw new Exception("Id cannot be null or unavailable");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
