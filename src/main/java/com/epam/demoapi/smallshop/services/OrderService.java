package com.epam.demoapi.smallshop.services;

import com.epam.demoapi.smallshop.domain.Order;
import com.epam.demoapi.smallshop.dto.OrderedProduct;

import java.util.List;

public interface OrderService {
    Order createOrder(List<OrderedProduct> orderedProductDtos);

    List<Order> getOrders();

    Order getOrder(Integer id);
}
