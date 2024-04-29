package controllers;


import DTO.OrderItemDto;
import model.OrderItemInfo;
import services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;



    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemDto dto) {
        OrderItemInfo orderItem = dto.toEntity();
        OrderItemInfo savedOrderItem = orderItemService.save(orderItem);
        return ResponseEntity.ok(new OrderItemDto(savedOrderItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
