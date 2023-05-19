package com.test.hexagonal.plate.infraestructure;

import com.test.hexagonal.commons.application.Mapper;
import com.test.hexagonal.commons.application.exceptions.NotFoundException;
import com.test.hexagonal.commons.infraestructure.exceptions.ServerErrorException;
import com.test.hexagonal.plate.application.PlateNoRestaurantIdDTO;
import com.test.hexagonal.plate.domain.IPlateRepository;
import com.test.hexagonal.plate.domain.PlateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class PlateSQLRepository implements IPlateRepository {

    @Autowired
    private PlateDAO plateDAO;
    @Autowired
    private Mapper modelMapper;
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Override
    public PlateModel save(PlateModel plate) {
        try {
            plateDAO.savePlate(
                    plate.getName(),
                    plate.getPrice(),
                    plate.getRestaurantId()
            );
            Long lastId = plateDAO.findLastInsertedPlateId();
            plate.setId(lastId);
            return plate;
        }catch (DataIntegrityViolationException e){
            throw new NotFoundException("Restaurant With $ID " + plate.getId() + " Not Found ");
        }catch (RuntimeException e){
            throw new ServerErrorException(e.getCause());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            plateDAO.deleteById(id);
        }catch (RuntimeException e){
            throw new ServerErrorException(e.getCause());
        }
    }
    @Override
    public boolean existById(Long id) {
        try {
            return plateDAO.existsById(id);
        } catch (RuntimeException e) {
            throw new ServerErrorException(e.getCause());
        }
    }

    @Override
    public List<PlateModel> getByRestaurantId(Long restaurantId) {
        //String sql = "SELECT * FROM plate WHERE restaurant_id = ?";
        try {
            //return jdbcTemplate.query(sql, new Object[]{restaurantId}, new BeanPropertyRowMapper<>(PlateModel.class));
            List<Object[]> platesObject = (List<Object[]>) plateDAO.findByIdRestaurant(restaurantId);
            return StreamSupport.stream(platesObject.spliterator(), false)
                    .map(row -> new PlateModel((Long) row[0], (String) row[1], (Integer) row[2]))
                    .collect(Collectors.toList());
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new ServerErrorException(e.getCause());
        }
    }
}
