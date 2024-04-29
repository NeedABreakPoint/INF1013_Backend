package controllers;


import DTO.RestaurantDto;
import model.RestaurantInfo;
import services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto dto) {
        RestaurantInfo restaurant = dto.toEntity();
        RestaurantInfo savedRestaurant = restaurantService.save(restaurant);
        return ResponseEntity.ok(new RestaurantDto(savedRestaurant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.delete(id);
        return ResponseEntity.ok().build();
    }
}
