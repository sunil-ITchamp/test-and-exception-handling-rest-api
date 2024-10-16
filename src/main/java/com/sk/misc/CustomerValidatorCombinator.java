package com.sk.misc;

import java.util.function.Function;
import static com.sk.misc.CustomerValidatorCombinator.*;
import static com.sk.misc.CustomerValidatorCombinator.ValidationResult.SUCCESS;
import static com.sk.misc.CustomerValidatorCombinator.ValidationResult.EMAIL_NOT_VALID;

public interface CustomerValidatorCombinator extends Function<Customer, ValidationResult> {

    static CustomerValidatorCombinator isEmailValid() {
        return customer -> customer.getEmail().contains("@")
                ? SUCCESS : EMAIL_NOT_VALID;
    }

    enum ValidationResult {
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NO_NOT_VALID,
        IS_NOT_AN_ADULT
    }

}
