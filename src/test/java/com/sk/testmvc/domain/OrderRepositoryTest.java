package com.sk.testmvc.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void test(){
        entityManager.persist(new Order(1L, 1000.00, true));
        entityManager.persist(new Order(2L, 500.00, false));
        entityManager.persist(new Order(3L, 1500.00, true));
        entityManager.persist(new Order(4L, 2500.00, true));

        List<Order> orderList = orderRepository.getAllDiscountOrders().collect(Collectors.toList());
        System.out.println("++++++++++++++++++++ " +  orderList.size());
        org.assertj.core.api.Assertions.assertThat(orderList).hasSize(3);
        System.out.println(orderList.get(2).getId() + " :: " + orderList.get(2).getTotalBill());
        org.assertj.core.api.Assertions.assertThat(orderList.get(2).getId()).isEqualTo(4L);
    }
}