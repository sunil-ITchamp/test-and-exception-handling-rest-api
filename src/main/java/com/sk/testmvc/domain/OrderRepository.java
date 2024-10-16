package com.sk.testmvc.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from Orders o where o.discount=true",nativeQuery = true)
    public Stream<Order> getAllDiscountOrders();
}
