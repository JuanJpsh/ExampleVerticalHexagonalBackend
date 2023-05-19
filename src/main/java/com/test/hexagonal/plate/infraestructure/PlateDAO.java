package com.test.hexagonal.plate.infraestructure;

import com.test.hexagonal.plate.application.PlateNoRestaurantIdDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PlateDAO extends CrudRepository<PlateEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO plate (name, price, restaurant_id) VALUES (:name, :price, :restaurantId);", nativeQuery = true)
    void savePlate(@Param("name") String name,
                   @Param("price") Integer price,
                   @Param("restaurantId") Long restaurantId
    );

    @Query(value = "SELECT id FROM plate WHERE id = LAST_INSERT_ID()", nativeQuery = true)
    Long findLastInsertedPlateId();

    @Query(value = "SELECT id, name, price FROM plate WHERE restaurant_id = :restaurantId", nativeQuery = true)
    Iterable<Object[]> findByIdRestaurant(@Param("restaurantId") Long restaurantId);
}
