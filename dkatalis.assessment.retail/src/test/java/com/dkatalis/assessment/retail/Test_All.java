package com.dkatalis.assessment.retail;

import com.dkatalis.assessment.retail.decorator.DiscountByBillAmountDecorator;
import com.dkatalis.assessment.retail.decorator.DiscountByItemsPurchasedDecorator;
import com.dkatalis.assessment.retail.decorator.DiscountByTimeDecorator;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class Test_All {

    @Test
    public void test_IfEmployee() {
        User user = new Employee();
        user.setName("Anovandri");
        user.setAddress("Depok");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -3);

        user.setRegisteredDate(calendar.getTime());

        Order order = new Order();
        order.setGrocier(false);
        order.setBillAmount(new BigDecimal(990));

        user.setOrder(order);

        Discount discount = ((Employee) user).getDiscount();

        Discount discountByBillAmount = new DiscountByBillAmountDecorator(discount,  user.getOrder().getBillAmount());
        Assert.assertEquals(45, discountByBillAmount.getDiscountByAmount().longValue());

        Discount discountByTime = new DiscountByTimeDecorator(discount, user.getRegisteredDate());
        Assert.assertEquals(0, discountByTime.getDiscountPercentage()); //apply on for customer not employee

        Discount discountByItemPurchased = new DiscountByItemsPurchasedDecorator(discount, user.getOrder().isGrocier());
        Assert.assertEquals(30, discountByItemPurchased.getDiscountPercentage());

        int discountPercentage = discount.getDiscountPercentage();
        BigDecimal discountAmount = discount.getDiscountByAmount();

        Assert.assertEquals(30, discountPercentage);
        Assert.assertEquals(45, discountAmount.longValue());

        /*Check bill*/
        long newBill = order.getBillAmount().longValue() - discountAmount.longValue();

        order.setDiscountAmount(discountAmount);

        Assert.assertEquals(990 - 45, order.getBillAmount().longValue() - order.getDiscountAmount().longValue());
    }
}
