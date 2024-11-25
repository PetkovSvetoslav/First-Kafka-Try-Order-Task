package com.task.Order.Processing.system.service;

import com.task.Order.Processing.system.model.Order;
import com.task.Order.Processing.system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final OrderRepository orderRepository;

    @Value("${order.topic}")
    private String topic;

    public OrderService(KafkaTemplate<String, Order> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order orderRequest) {
        Order order = new Order();

        order.setName(orderRequest.getName());
        order.setProduct(orderRequest.getProduct());
        order.setQuantity(orderRequest.getQuantity());
        order.setStatus("PENDING");
        order.setProcessedAt(null);

        Order savedOrder = orderRepository.save(order);

        kafkaTemplate.send(topic, savedOrder);
    }


//    @KafkaListener(topics = "${order.topic}", groupId = "order_group", containerFactory = "kafkaListenerContainerFactory")
//    @ConditionalOnProperty(name = "spring.kafka.bootstrap-servers", havingValue = "localhost:9092", matchIfMissing = true)
    @KafkaListener(topics = "${order.topic}", groupId = "order_group")
    public void processOrder(Order order) {
        try {
            Thread.sleep(2000); // Simulate processing
            order.setStatus("PROCESSED");
            order.setProcessedAt(LocalDateTime.now());
            orderRepository.save(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public List<Order> getProcessedOrders() {
        return orderRepository.findByStatus("PROCESSED");
    }

}

