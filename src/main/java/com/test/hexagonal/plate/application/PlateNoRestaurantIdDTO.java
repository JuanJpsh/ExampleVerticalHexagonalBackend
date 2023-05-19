package com.test.hexagonal.plate.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PlateNoRestaurantIdDTO {
    private Long id;
    private String name;
    private Integer price;

    public PlateNoRestaurantIdDTO() {
    }

    public PlateNoRestaurantIdDTO(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
