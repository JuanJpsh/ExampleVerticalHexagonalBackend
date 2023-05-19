package com.test.hexagonal.restaurant.infraestructure;

import com.test.hexagonal.commons.application.Mapper;
import com.test.hexagonal.commons.infraestructure.exceptions.ServerErrorException;
import com.test.hexagonal.restaurant.domain.IRestaurantRepository;
import com.test.hexagonal.restaurant.domain.RestaurantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantSQLRepository implements IRestaurantRepository {

    @Autowired
    private RestaurantDAO restaurantDAO;
    @Autowired
    private Mapper modelMapper;

    @Override
    public RestaurantModel save(RestaurantModel restaurant) {
        RestaurantEntity restaurantEntity = modelMapper.map(restaurant, RestaurantEntity.class);
        try {
            RestaurantEntity savedEntity = restaurantDAO.save(restaurantEntity);
            return modelMapper.map(savedEntity, RestaurantModel.class);
        }catch (RuntimeException e){
            throw new ServerErrorException(e.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            restaurantDAO.deleteById(id);
        }catch (RuntimeException e){
            throw new ServerErrorException(e.getCause());
        }
    }

    @Override
    public boolean existById(Long id) {
        try {
            return restaurantDAO.existsById(id);
        } catch (RuntimeException e) {
            throw new ServerErrorException(e.getCause());
        }
    }
}
