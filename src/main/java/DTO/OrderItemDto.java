package dto;

import model.OrderItemInfo;

public class OrderItemDto {
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double unitPrice;

    // Constructor to initialize from an entity
    public OrderItemDto(OrderItemInfo savedOrderItem) {
        this.id = savedOrderItem.getId();
        this.orderId = savedOrderItem.getOrder().getId(); // Assuming Order has a getId method
        this.productId = savedOrderItem.getProductId();
        this.quantity = savedOrderItem.getQuantity();
        this.unitPrice = savedOrderItem.getUnitPrice();
    }

    // Method to convert DTO to entity
    public OrderItemInfo toEntity() {
        OrderItemInfo orderItem = new OrderItemInfo();
        orderItem.setId(this.id);
        orderItem.setProductId(this.productId);
        orderItem.setQuantity(this.quantity);
        orderItem.setUnitPrice(this.unitPrice);
        // Assume the Order reference needs to be set outside of this method
        return orderItem;
    }

    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
