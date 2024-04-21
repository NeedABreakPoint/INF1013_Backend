package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderItemInfo {
    // Getters and setters
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderInfo order; // Reference to the associated order

    @Column(nullable = false)
    private Long productId; // Product ID

    @Column(nullable = false)
    private Integer quantity; // Quantity of the product ordered

    @Column(nullable = false)
    private Double unitPrice; // Price per unit of the product

}