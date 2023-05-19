package com.test.hexagonal.plate.domain;

import com.test.hexagonal.commons.domain.IGenericRepositoryPort;

import java.util.List;

public interface IPlateRepository extends IGenericRepositoryPort<PlateModel> {
    List<PlateModel> getByRestaurantId(Long restaurantId);
}
