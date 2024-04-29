package services;

import model.RestaurantInfo;
import repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    public RestaurantInfo findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public RestaurantInfo save(RestaurantInfo restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}
