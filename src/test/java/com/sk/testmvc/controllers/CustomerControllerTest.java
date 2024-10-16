package com.sk.testmvc.controllers;

import com.sk.testmvc.domain.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllPrimeCustomers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/primecustomers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}