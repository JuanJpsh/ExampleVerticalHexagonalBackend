package com.test.hexagonal.restaurant.infraestructure;

import com.test.hexagonal.restaurant.domain.RestaurantModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
public class RestaurantEntity{
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    @Size(min = 3)
    private String name;

    public RestaurantEntity() {}

    public RestaurantEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
