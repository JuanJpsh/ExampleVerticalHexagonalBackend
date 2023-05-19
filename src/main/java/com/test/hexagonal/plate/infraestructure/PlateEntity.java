package com.test.hexagonal.plate.infraestructure;

import com.test.hexagonal.plate.domain.PlateModel;
import com.test.hexagonal.restaurant.infraestructure.RestaurantEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plate")
@Getter
@Setter
public class PlateEntity {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    @Size(min = 3)
    private String name;
    @Column(nullable = false)
    @Positive
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantEntity restaurant;

    public PlateEntity() {
    }

    public PlateEntity(Long id, String name, Integer price, RestaurantEntity restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
}
