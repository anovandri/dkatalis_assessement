package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;
import com.dkatalis.assessment.retail.EmployeeDiscount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class Test_ByTimeDecorator {

    DiscountByTimeDecorator discountByTimeDecorator;

    @Before
    public void initiate() {
        Discount discount = new EmployeeDiscount();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -3);
        discountByTimeDecorator = new DiscountByTimeDecorator(discount, calendar.getTime());
    }

    @Test
    public void test_getDiscountByAmount() {
        int discountPercentage = discountByTimeDecorator.getDiscountPercentage();
        Assert.assertEquals(5, discountPercentage);
    }

    @Test
    public void test_isApply() {
        Assert.assertEquals(true, discountByTimeDecorator.isApply());
    }
}
