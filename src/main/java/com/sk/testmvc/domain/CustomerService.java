package com.sk.testmvc.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        System.out.println("--------------Constructor ++ CustomerService ++ -----------------");
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findCustomerById(Long id){
        //Long customerId = Long.getLong(id);
        Optional<Customer> customerOptional = customerRepository.findById(id);
        System.out.println(customerOptional.isPresent());
        return customerOptional;
    }

    public List<Customer> getAllPrimeMembers(){
        System.out.println("Real time object is called.");
        return customerRepository.getAllPrimeMembers();
    }

    public Customer saveCustomer(Customer customer){

        //business logic
        if (customer.isPrime() == true){

        }
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public void deleteCustomer(Long id) {
        Customer toDelete = customerRepository.findById(id).get();
        customerRepository.delete(toDelete);
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
}
