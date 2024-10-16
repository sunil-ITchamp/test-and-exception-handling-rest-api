package com.sk.testmvc.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup(){
    customerRepository = Mockito.mock(CustomerRepository.class);
    customerService = new CustomerService(customerRepository);
    }

    @Test
    void findCustomerById() {
        Customer c1 = new Customer(1L, "customer1","customer1@gmail.com", true);
        Customer c2 = new Customer(2L, "customer2","customer2@gmail.com", true);

        BDDMockito.given(customerRepository.getAllPrimeMembers()).willReturn(List.of(c1,c2));
        List<Customer> listCustomer = customerService.getAllPrimeMembers();
        Assertions.assertThat(listCustomer).hasSize(2);
        Assertions.assertThat(listCustomer.get(0).getId()).isEqualTo(1L);


    }
}