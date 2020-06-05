package com.epam.demoapi.smallshop;

import com.epam.demoapi.smallshop.domain.Product;
import com.epam.demoapi.smallshop.dto.OrderedProduct;
import com.epam.demoapi.smallshop.repo.OrderRepository;
import com.epam.demoapi.smallshop.repo.ProductRepository;
import com.epam.demoapi.smallshop.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class TestClass {
    private ProductRepository productRepository;
    private OrderService orderService;
    private OrderRepository orderRepository;

    @PostConstruct
    public void test() {
        productRepository.save(Product.builder().name("burger").price(15).build());
        productRepository.save(Product.builder().name("fries").price(10).build());
        productRepository.save(Product.builder().name("coke").price(5).build());
        productRepository.save(Product.builder().name("ice-cream").price(10).build());

        List<OrderedProduct> orderedProducts = Arrays.asList(
                new OrderedProduct(1, 2),
                new OrderedProduct(2, 3),
                new OrderedProduct(3, 4)
        );
        List<OrderedProduct> orderedProducts2 = Arrays.asList(
                new OrderedProduct(2, 2),
                new OrderedProduct(4, 5)
        );

        orderService.createOrder(orderedProducts);
        orderService.createOrder(orderedProducts2);

        int i = 2; //line for a breakpoint
    }
}
