package com.sk.testmvc.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureDataJpa ()
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Customer deleteCustomer;

    private Long deleteCustomerID;

    @BeforeEach
    public void setup(){
        Customer c1 = new Customer(null, "customer1","customer1@gmail.com", true);
        Customer c2 = new Customer(null, "customer2","customer2@gmail.com", false);
        deleteCustomer = new Customer(null, "deleteCustomer1","deleteCustomer1@gmail.com", false);
        entityManager.persist(c1);

        //Differnt way to persist and get PK
        Long c2ID = entityManager.persistAndGetId(c2, Long.class);
        System.out.println(c2ID);
        //entityManager.persist(deleteCustomer);
        deleteCustomerID = entityManager.persistAndGetId(deleteCustomer, Long.class);
        System.out.println(deleteCustomerID);
    }

//    @Test
//    public void test_findAllPrimeMembers_getAllPrimeMembers(){
//       List<Customer> customerList = customerRepository.getAllPrimeMembers();
//        assertThat(customerList).hasSize(1);
//        assertThat(customerList.get(0).getId()).isEqualTo(1L);
//    }

    //Create
    @Test
    public void test_createCustomer_save(){
        //Use Builder pattern
        Customer customer3 = Customer.builder()
                .email("customer3@gmail.com")
                .name("customer3")
                .prime(true)
                .build();

        Customer customerSaved = customerRepository.save(customer3);
        assertThat(customerSaved).isNotNull();
        assertThat(customerSaved.getId()).isGreaterThan(0L);
        assertThat(customerSaved.isPrime()).isEqualTo(true);
        assertThat((customerSaved.getName())).isEqualTo("customer3");

    }


    //Read
    @Test
    public void test_readCustomer_findAll(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println(customerList.size());
        assertThat(customerList).isNotNull();
        assertThat(customerList.size()).isEqualTo(3);


    }

    //Update
    @Test
    public void test_updateCustomer_update(){
        Customer c4 = new Customer(null, "customer4","customer4@gmail.com", false);
        Customer updateCustomer = customerRepository.save(c4);

        updateCustomer.setEmail("customer4_udpated@gmail.com");
        updateCustomer.setPrime(true);
        updateCustomer = customerRepository.save(updateCustomer);

        assertThat(updateCustomer).isNotNull();
        assertThat(updateCustomer.getId()).isGreaterThan(0L);
        assertThat((updateCustomer.getName())).isEqualTo("customer4");
        assertThat(updateCustomer.isPrime()).isEqualTo(true);

    }

    //Delete
    @Test
    public void test_deleteCustomer_delete(){
        customerRepository.delete(deleteCustomer);

        //2 ways to TEST delete
        //a) Test with entityManager.find which will return NULL object
        Customer customer = entityManager.find(Customer.class, deleteCustomer.getId());
        assertThat(customer).isNull();
        //b) Test with Optional which will return EMPTY object due to no record in DB
//        Optional<Customer> customer = customerRepository.findById(deleteCustomerID);
//        assertThat(customer).isEmpty();

    }

}