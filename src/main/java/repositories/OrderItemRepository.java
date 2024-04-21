package repositories;



import model.OrderItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemInfo, Long> {
}
