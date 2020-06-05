package com.epam.demoapi.smallshop.services;

import com.epam.demoapi.smallshop.domain.Order;
import com.epam.demoapi.smallshop.domain.Product;
import com.epam.demoapi.smallshop.dto.OrderedProduct;
import com.epam.demoapi.smallshop.repo.OrderRepository;
import com.epam.demoapi.smallshop.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Override
    public Order createOrder(List<OrderedProduct> orderedProductDtos) {
        List<Product> orderedProducts = orderedProductDtos.stream()
                .map(op -> Pair.of(op.getQuantity(), getProduct(op.getId())))
                .filter(pair -> pair.getSecond().isPresent())
                .map(pair -> Pair.of(pair.getFirst(), pair.getSecond().get()))
                .flatMap(pair -> Stream.generate(pair::getSecond).limit(pair.getFirst()))
                .collect(Collectors.toList());

        return orderRepository.save(
                Order.builder()
                .products(orderedProducts)
                .totalPrice(orderedProducts.stream().mapToInt(Product::getPrice).sum())
                .build()
        ) ;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Integer id) {
        return orderRepository.getOne(id);
    }

    private Optional<Product> getProduct(Integer id) {
        return productRepository.findById(id);
    }
}
