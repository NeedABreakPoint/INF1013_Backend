package DTO;

import model.OrderInfo;
import java.time.LocalDateTime;

public class OrderDto {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private Double totalPrice;
    private String status;
    private LocalDateTime orderTime;
    private LocalDateTime deliveryTime;

    // Constructor that initializes the DTO from an OrderInfo entity
    public OrderDto(OrderInfo order) {
        if (order != null) {
            this.id = order.getId();
            this.userId = order.getUserId();
            this.restaurantId = order.getRestaurantId();
            this.totalPrice = order.getTotalPrice();
            this.status = order.getStatus();
            this.orderTime = order.getOrderTime();
            this.deliveryTime = order.getDeliveryTime();
        }
    }

    // Method to convert DTO back to entity
    public OrderInfo toEntity() {
        OrderInfo order = new OrderInfo();
        order.setId(this.id);
        order.setUserId(this.userId);
        order.setRestaurantId(this.restaurantId);
        order.setTotalPrice(this.totalPrice);
        order.setStatus(this.status);
        order.setOrderTime(this.orderTime);
        order.setDeliveryTime(this.deliveryTime);
        return order;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
