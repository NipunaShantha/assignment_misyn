package com.misyn.assignment.controller;

import com.misyn.assignment.entity.OrderDetails;
import com.misyn.assignment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/order-service")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrders() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDetails> getSelectedOrder(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getSelectedOrder(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.createOrder(orderDetails));
    }

    @PutMapping
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails orderDetails) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderDetails));
    }

    @PutMapping(value = "/{orderId}/{orderStatus}")
    public ResponseEntity<OrderDetails> updateOrderStatus(@PathVariable Long orderId, @PathVariable String orderStatus) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderStatus(orderId, orderStatus));
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(orderId));
    }

}
