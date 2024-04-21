package repositories;

import model.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantInfo, Long> {
}