package com.dkatalis.assessment.retail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_CustomerDiscount {

    Discount discount;

    @Before
    public void initiate() {
        SetCustomerDiscount setDiscount = new SetCustomerDiscount();
        discount = setDiscount.setDiscount();
    }

    @Test
    public void test_getDiscountAmount() {
        Assert.assertEquals(0l, ((CustomerDiscount) discount).getDiscountByAmount().longValue());
    }

    @Test
    public void test_getDiscountPercentage() {
        Assert.assertEquals(0, ((CustomerDiscount) discount).getDiscountPercentage());
    }
}
