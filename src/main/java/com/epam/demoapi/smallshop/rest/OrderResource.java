package com.epam.demoapi.smallshop.rest;

import com.epam.demoapi.smallshop.domain.Order;
import com.epam.demoapi.smallshop.dto.OrderedProduct;
import com.epam.demoapi.smallshop.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderResource {
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(List<OrderedProduct> orderedProducts) {
        if (orderedProducts.size() < 100) {
            return orderService.createOrder(orderedProducts);
        } else throw new IllegalArgumentException();
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(List<OrderedProduct> orderedProducts) {
        if (orderedProducts.size() < 100) {
            return orderService.createOrder(orderedProducts);
        } else throw new IllegalArgumentException();
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(Integer id) {
        orderService.deleteOrder(id);
    }
}
