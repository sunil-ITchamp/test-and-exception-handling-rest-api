package com.sk.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.flywaydb.core.internal.util.JsonUtils;

import static com.sk.misc.CustomerValidatorCombinator.ValidationResult;
import static com.sk.misc.CustomerValidatorCombinator.isEmailValid;
import static com.sk.misc.ExampleBiFunction.*;
import static com.sk.misc.ExampleBiFunction.DiscountResult;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private String email;
    private String phoneNo;
    private LocalDate dob;
    private boolean prime;

    public static void main(String[] args) {
        Customer customer = new Customer("SK",
                "skgmail.com",
                "+19295059436",
                LocalDate.of(2002, 1,1),
                true);

        CustomerValidator validator = new CustomerValidator();

//        System.out.println("Email validation - " + validator.isEmailValid(customer));
//        System.out.println("Phone validation - " + validator.isPhoneValid(customer));
//        System.out.println("Adult validation - " + validator.isCustomerAdult(customer));
//
//        System.out.println("Customer validation - " + validator.isCustomerValid(customer));

        ValidationResult validationResult = isEmailValid().apply(customer);
        System.out.println(" Output : " + validationResult);

        System.out.println(addOne(10));

        Function<Integer, Integer> incrementByOne = (i1)-> i1+1;

        Function<Integer, Integer> multiplyByTwo = (i1)-> i1*2;

        Function<Integer, Integer> divideByTwo = (i1)-> i1/3;

        BiFunction<Customer, Integer, String> var = (c,a)-> c.getEmail();

        System.out.println(" The Result " + divideByTwo.compose(multiplyByTwo.compose(incrementByOne)).apply(5));

//        System.out.println(var.apply(customer,10));
//        System.out.println(" The Result " + incrementByOne.andThen(multiplyByTwo).andThen(divideByTwo).apply(100));
        //System.out.println(multiplyByTwo.apply(100));

        //ExampleBiFunction exampleBiFunction = isDiscountApplicable().andThen(isDoubleDiscountApplicable().apply());
        //System.out.println(exampleBiFunction.apply(customer, false));

        //ExampleBiFunction.DiscountResult discountResult = exampleBiFunction.apply(customer, true);
        //System.out.println(discountResult);

//        DiscountResult discountResult = (isDoubleDiscountApplicable()).apply(customer, true);
//        System.out.println(discountResult);

        DiscountResult discountResult = isDiscountApplicable().and(isDoubleDiscountApplicable()).apply(customer, false);
        System.out.println(discountResult);
    }

    public static Integer addOne(Integer i1){
        return i1+1;
    }
}
