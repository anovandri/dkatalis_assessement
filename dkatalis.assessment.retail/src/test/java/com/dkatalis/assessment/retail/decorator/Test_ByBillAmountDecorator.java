package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;
import com.dkatalis.assessment.retail.EmployeeDiscount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class Test_ByBillAmountDecorator {

    DiscountByBillAmountDecorator discountByBillAmountDecorator;

    @Before
    public void initiate() {
        Discount discount = new EmployeeDiscount();
        discountByBillAmountDecorator = new DiscountByBillAmountDecorator(discount, new BigDecimal(990));
    }

    @Test
    public void test_getDiscountByAmount() {
        BigDecimal discountByAmount = discountByBillAmountDecorator.getDiscountByAmount();
        Assert.assertEquals(45l, discountByAmount.longValue());
    }

    @Test
    public void test_isApply() {
        Assert.assertEquals(true, discountByBillAmountDecorator.isApply());
    }

}
