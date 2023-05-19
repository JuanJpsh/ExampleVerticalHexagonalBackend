package com.test.hexagonal.restaurant.application;

import com.test.hexagonal.commons.application.Mapper;
import com.test.hexagonal.commons.application.exceptions.NotFoundException;
import com.test.hexagonal.restaurant.domain.IRestaurantRepository;
import com.test.hexagonal.restaurant.domain.IRestaurantService;
import com.test.hexagonal.restaurant.domain.RestaurantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService implements IRestaurantService {
    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Override
    public RestaurantModel create(RestaurantModel restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        if (!restaurantRepository.existById(id))
            throw new NotFoundException("Restaurant With $ID " + id + " Not Found");
        restaurantRepository.delete(id);
    }
}
