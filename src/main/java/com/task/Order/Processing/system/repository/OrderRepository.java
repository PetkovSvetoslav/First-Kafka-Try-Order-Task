package com.task.Order.Processing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.Order.Processing.system.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
}

