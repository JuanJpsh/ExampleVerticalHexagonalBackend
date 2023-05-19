package com.test.hexagonal.plate.infraestructure;

import com.test.hexagonal.commons.application.Mapper;
import com.test.hexagonal.plate.domain.IPlateService;
import com.test.hexagonal.plate.application.PlateNoRestaurantIdDTO;
import com.test.hexagonal.plate.domain.PlateModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("plate")
public class PlateController {
    @Autowired
    private IPlateService plateService;
    @Autowired
    private Mapper modelMapper;

    @PostMapping(produces = "application/json")
    public ResponseEntity<PlateModel> createPlate (@Valid @RequestBody PlateModel plate){
        PlateModel savedPlate = plateService.create(plate);
        return new ResponseEntity<>(savedPlate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlate (@PathVariable Long id){
        plateService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{restaurantId}",produces = "application/json")
    public ResponseEntity<List<PlateNoRestaurantIdDTO>> getPlatesByIdRestaurant(@PathVariable Long restaurantId){
        List<PlateModel> plates = plateService.getByRestaurantId(restaurantId);
        List<PlateNoRestaurantIdDTO> platesDTO = plates.stream()
                .map(plateModel -> modelMapper.map(plateModel, PlateNoRestaurantIdDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(platesDTO, HttpStatus.OK);
    }
}
