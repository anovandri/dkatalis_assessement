package com.dkatalis.assessment.retail;

import java.math.BigDecimal;

public class SetEmployeeDiscount {

    public Discount setDiscount() {
        Discount discount = new EmployeeDiscount();
        return discount;
    }
}
