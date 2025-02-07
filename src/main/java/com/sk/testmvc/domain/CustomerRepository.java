package com.sk.testmvc.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select c from Customer c where c.prime=true")
    public List<Customer> getAllPrimeMembers();

    @Query(value = "select c from Customer c where c.email=:emailAddress")
    public Optional<Customer> findCustomerByEmail(String emailAddress);
}
