package com.sk.testmvc.controllers;

import com.sk.testmvc.domain.Customer;
import com.sk.testmvc.domain.CustomerService;
import com.sk.testmvc.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/secure/welcome")
    public String welcome(Principal principal){
        return "hello " + principal.getName();
    }

    @GetMapping("/api/primecustomers")
    public List<Customer> getAllPrimeCustomers(){
        List<Customer> customerList = customerService.getAllPrimeMembers();
        System.out.println(customerList.size());
        return customerList;
    }

    //create
    @PostMapping("/api/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok().body(customerService.saveCustomer(customer));
    }

    //-------- GET mapping cannot have same paths with different PathVariable such as /api/customers/ with {id} and {email} - Ambiguous error on server
    //read - byid and byemail is to differentiate 2 GET paths
    @GetMapping("/api/customers/byid/{id}")
    public ResponseEntity<Customer> readCustomerById(@PathVariable Long id){
            Customer customer = customerService.findCustomerById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return ResponseEntity.ok(customer);
    }


    @GetMapping("/api/customers/byemail/{email}")
    public ResponseEntity<Customer> readCustomerByEmail(@PathVariable String email){
        System.out.println("+++++++++++++++++++++++++++ " + email);
        Customer customer = customerService.findCustomerByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){
        System.out.println("==========================================  Inside getAllCusutomers() ================");
        if (true) {
            throw new CustomerNotFoundException();
        }
        List<Customer> customerList = customerService.findAllCustomers();
        System.out.println(customerList.size());
        return customerList;
    }
    //-------- GET mapping cannot have same paths with different PathVariable such as /api/customers/ with {id} and {email} - Ambiguous error on server
    //update
    @PutMapping("/api/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer toUpdate = customerService.findCustomerById( customer.getId()).get();
        toUpdate.setName(customer.getName());
        toUpdate.setEmail(customer.getEmail());
        toUpdate.setPrime(customer.isPrime());
        return ResponseEntity.ok(customerService.saveCustomer(toUpdate));
    }


    //delete
    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
