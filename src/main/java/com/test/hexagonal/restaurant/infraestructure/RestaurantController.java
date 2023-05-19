package com.test.hexagonal.restaurant.infraestructure;

import com.test.hexagonal.restaurant.domain.IRestaurantService;
import com.test.hexagonal.restaurant.domain.RestaurantModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("restaurant")
public class RestaurantController {
    @Autowired
    private IRestaurantService restaurantService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<RestaurantModel> createRestaurant (@Valid @RequestBody RestaurantModel restaurant){
        RestaurantModel savedRestaurant = restaurantService.create(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurant (@PathVariable Long id){
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
