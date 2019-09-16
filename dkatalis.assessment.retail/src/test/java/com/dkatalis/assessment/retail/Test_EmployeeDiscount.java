package com.dkatalis.assessment.retail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_EmployeeDiscount {

    Discount discount;

    @Before
    public void initiate() {
        SetEmployeeDiscount setDiscount = new SetEmployeeDiscount();
        discount = setDiscount.setDiscount();
    }

    @Test
    public void test_getDiscountAmount() {
        Assert.assertEquals(0l, ((EmployeeDiscount) discount).getDiscountByAmount().longValue());
    }

    @Test
    public void test_getDiscountPercentage() {
        Assert.assertEquals(30, ((EmployeeDiscount) discount).getDiscountPercentage());
    }
}
