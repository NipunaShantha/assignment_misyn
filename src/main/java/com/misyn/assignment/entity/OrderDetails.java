package com.misyn.assignment.entity;

import com.misyn.assignment.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long orderId;
    @Column(updatable = false)
    private LocalDateTime orderCreatedDate = LocalDateTime.now();
    @Column
    private LocalDateTime orderModifiedDate = LocalDateTime.now();
    @Column
    private String senderName;
    @Column
    private String senderAddress;
    @Column
    private String receiverName;
    @Column
    private String receiverAddress;
    @Column
    private String parcelWeight;
    @ManyToOne
    @JoinColumn(name = "company_code")
    private CourierCompany courierCompany;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus recordStatus = OrderStatus.PLACED;
}
