package com.sk.misc;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiFunction;
import static com.sk.misc.ExampleBiFunction.*;
//import static com.sk.misc.ExampleBiFunction.DiscountResult;

public interface ExampleBiFunction extends BiFunction<Customer, Boolean, DiscountResult> {

    static ExampleBiFunction isDiscountApplicable(){
        return (c, b) -> c.isPrime()== b ? DiscountResult.YES_Discount_is_applicable : DiscountResult.NO_Discount_is_not_applicable;
    }

    static ExampleBiFunction isDoubleDiscountApplicable(){
        return (c, b) ->
                 Period.between(c.getDob(), LocalDate.now()).getYears() > 21 ? DiscountResult.YES_Double_Discount_is_applicable : DiscountResult.NO_Discount_is_not_applicable;
    }

    default ExampleBiFunction and (ExampleBiFunction other){
        return (c,b) -> {
            DiscountResult result = this.apply(c, b);
            return result.equals(DiscountResult.NO_Discount_is_not_applicable)?other.apply(c,b):result;
        };
    }
    enum DiscountResult{
        YES_Discount_is_applicable,
        NO_Discount_is_not_applicable,
        YES_Double_Discount_is_applicable
    }
}
