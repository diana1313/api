package com.epam.demoapi.smallshop.rest;

import com.epam.demoapi.smallshop.domain.Order;
import com.epam.demoapi.smallshop.dto.OrderedProduct;
import com.epam.demoapi.smallshop.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrderResource {
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(List<OrderedProduct> orderedProducts) {
        return orderService.createOrder(orderedProducts);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping
    public Order getOrder(Integer id) {
        return orderService.getOrder(id);
    }

}
