package com.test.hexagonal.plate.domain;

import com.test.hexagonal.commons.application.port_in.IGenericServicePort;

import java.util.List;

public interface IPlateService extends IGenericServicePort<PlateModel> {
    List<PlateModel> getByRestaurantId(Long restaurantId);
}
