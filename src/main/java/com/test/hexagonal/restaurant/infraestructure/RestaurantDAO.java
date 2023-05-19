package com.test.hexagonal.restaurant.infraestructure;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantDAO extends CrudRepository<RestaurantEntity, Long> {
}
