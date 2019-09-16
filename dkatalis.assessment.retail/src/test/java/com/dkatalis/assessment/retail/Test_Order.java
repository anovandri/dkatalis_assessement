package com.dkatalis.assessment.retail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class Test_Order {

    private Order order;

    @Before
    public void initiate() {
        SetOrder setOrder = new SetOrder();
        order = setOrder.setOrder();
    }

    @Test
    public void test_getGrocier() {
        Assert.assertEquals(true, order.isGrocier());
    }

    @Test
    public void test_getBillAmount() {
        Assert.assertEquals(990l, order.getBillAmount().longValue());
    }

    @Test
    public void test_setDiscountAmount() {
        Assert.assertEquals(10, order.getDiscountAmount().longValue());
    }
}
