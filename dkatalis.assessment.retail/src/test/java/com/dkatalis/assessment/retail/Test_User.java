package com.dkatalis.assessment.retail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class Test_User {

    Order order;
    User user;
    Discount discount;

    @Before
    public void initiate() {
        SetOrder setOrder = new SetOrder();
        order = setOrder.setOrder();

        SetUser setUser = new SetUser();
        user = setUser.setUser();
        user.setOrder(order);

        SetEmployeeDiscount setDiscount = new SetEmployeeDiscount();
        discount = setDiscount.setDiscount();
        ((Employee) user).setDiscount(discount);
    }

    @Test
    public void test_getName() {
        Assert.assertEquals("Anovandri", user.getName());
    }

    @Test
    public void test_getAddress() {
        Assert.assertEquals("Depok", user.getAddress());
    }

    @Test
    public void test_getRegisteredDate() {
        Assert.assertEquals(new Date(), user.getRegisteredDate());
    }
}
