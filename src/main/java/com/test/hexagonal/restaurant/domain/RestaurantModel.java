package com.test.hexagonal.restaurant.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantModel {
    private Long id;
    @NotBlank(message = "Name cannot be null or blank")
    @Size(min = 3, max = 30, message = "Name Length Should Be a Minimum of 3 Characters and a Maximum of 30 Characters")
    private String name;
}
