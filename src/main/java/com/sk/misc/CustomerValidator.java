package com.sk.misc;
import com.sk.misc.Customer;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidator {

    public boolean isEmailValid(Customer customer){
                if (customer.getEmail().contains("@")){
                    return true;
                }
                return false;
    }

    public boolean isPhoneValid(Customer customer){
        if (customer.getPhoneNo().startsWith("+1") && (customer.getPhoneNo().length() == 12)){
            return true;
        }
        return false;
    }

    public boolean isCustomerAdult(Customer customer){
        if ( Period.between(customer.getDob(), LocalDate.now()).getYears() > 18){
            return true;
        }
        return false;
    }

    public boolean isCustomerValid(Customer customer){
        return this.isEmailValid(customer) && this.isPhoneValid(customer) && this.isCustomerAdult(customer);
    }
}
