package com.task.Order.Processing.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

//  Here I create constructor, getter and setter, just to show I know how :)

//    public Order(Long id, String name, String product, int quantity, String status, LocalDateTime processedAt) {
//        this.id = id;
//        this.name = name;
//        this.product = product;
//        this.quantity = quantity;
//        this.status = status;
//        this.processedAt = processedAt;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getProduct() {
//        return product;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public LocalDateTime getProcessedAt() {
//        return processedAt;
//    }
//
//    public void setProcessedAt(LocalDateTime processedAt) {
//        this.processedAt = processedAt;
//    }
}
