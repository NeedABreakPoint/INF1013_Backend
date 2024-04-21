package services;

import model.OrderInfo;
import repositories.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderInfoRepository repository;

    public List<OrderInfo> findAll() {
        return repository.findAll();
    }

    public OrderInfo findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OrderInfo save(OrderInfo orderInfo) {
        return repository.save(orderInfo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
