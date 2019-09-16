package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;
import com.dkatalis.assessment.retail.EmployeeDiscount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_ByItemsPurchasedDecorator {

    DiscountByItemsPurchasedDecorator discountByItemsPurchasedDecorator;

    @Before
    public void initiate() {
        Discount discount = new EmployeeDiscount();
        discountByItemsPurchasedDecorator = new DiscountByItemsPurchasedDecorator(discount, true);
    }

    @Test
    public void test_getDiscountByAmount() {
        int discountPercentage = discountByItemsPurchasedDecorator.getDiscountPercentage();
        Assert.assertEquals(0, discountPercentage);
    }

    @Test
    public void test_isApply() {
        Assert.assertEquals(true, discountByItemsPurchasedDecorator.isApply());
    }
}
