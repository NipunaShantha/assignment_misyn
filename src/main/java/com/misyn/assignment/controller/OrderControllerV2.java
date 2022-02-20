package com.misyn.assignment.controller;

import com.misyn.assignment.entity.OrderDetailsV2;
import com.misyn.assignment.service.OrderServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v2/order-service")
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    @GetMapping
    public ResponseEntity<List<OrderDetailsV2>> getAllOrders() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderDetailsV2> getSelectedOrder(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getSelectedOrder(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDetailsV2> createOrder(@RequestBody OrderDetailsV2 orderDetails) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.createOrder(orderDetails));
    }

    @PutMapping
    public ResponseEntity<OrderDetailsV2> updateOrder(@RequestBody OrderDetailsV2 orderDetails) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderDetails));
    }

    @PutMapping(value = "/{orderId}/{orderStatus}")
    public ResponseEntity<OrderDetailsV2> updateOrderStatus(@PathVariable Long orderId, @PathVariable String orderStatus) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderStatus(orderId, orderStatus));
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable Long orderId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.deleteOrder(orderId));
    }

}
