package controllers;

import dto.OrderDto;
import model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderInfos")
public class OrderInfoController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> dtos = service.findAll().stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDTO) {
        OrderInfo order = service.save(orderDTO.toEntity());
        return ResponseEntity.ok(new OrderDto(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
