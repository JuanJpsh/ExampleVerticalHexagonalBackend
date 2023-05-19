package com.test.hexagonal.plate.application;

import com.test.hexagonal.commons.application.Mapper;
import com.test.hexagonal.commons.application.exceptions.NotFoundException;
import com.test.hexagonal.plate.domain.IPlateRepository;
import com.test.hexagonal.plate.domain.IPlateService;
import com.test.hexagonal.plate.domain.PlateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlateService implements IPlateService {
    @Autowired
    private IPlateRepository plateRepository;
    @Autowired
    private Mapper modelMapper;

    @Override
    public PlateModel create(PlateModel plate) {
        return plateRepository.save(plate);
    }

    @Override
    public void delete(Long id) {
        if (!plateRepository.existById(id))
            throw new NotFoundException("Plate With $ID " + id + " Not Found");
        plateRepository.delete(id);
    }

    @Override
    public List<PlateModel> getByRestaurantId(Long restaurantId) {
        return  plateRepository.getByRestaurantId(restaurantId);
    }
}
