package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "orderInfo")
public class OrderInfo {
    // Getters and Setters
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId; // Optional, nullable if not every order requires a user

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @OneToMany(mappedBy = "order")
    private List<OrderItemInfo> items; // Assuming OrderItemInfo is already defined elsewhere

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(nullable = false)
    private String status;

    @Column(name = "order_time", nullable = false)
    private LocalDateTime orderTime;

    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

}
