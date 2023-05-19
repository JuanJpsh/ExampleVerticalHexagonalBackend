package com.test.hexagonal.plate.domain;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PlateModel {
    private Long id;
    @NotBlank(message = "Name cannot be null or blank")
    @Size(min = 3, max = 30, message = "Name Length Should Be a Minimum of 3 Characters and a Maximum of 30 Characters")
    private String name;
    @Positive(message = "Price Cannot Be Less Than Zero")
    @NonNull
    private Integer price;
    @Positive(message = "RestaurantId Cannot Be Less Than Zero")
    @NonNull
    private Long restaurantId;

    public PlateModel(Long id, String name, @NonNull Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
