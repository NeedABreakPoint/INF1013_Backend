package services;


import model.OrderItemInfo;
import repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItemInfo> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItemInfo findById(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    public OrderItemInfo save(OrderItemInfo orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}
