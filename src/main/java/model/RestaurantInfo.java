package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "restaurantsInfo")
public class RestaurantInfo {
    // Setters
    // Getters
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String category;

}
