package com.dkatalis.assessment.retail;

import com.dkatalis.assessment.retail.decorator.DiscountByBillAmountDecorator;
import com.dkatalis.assessment.retail.decorator.DiscountByItemsPurchasedDecorator;
import com.dkatalis.assessment.retail.decorator.DiscountByTimeDecorator;

import java.math.BigDecimal;
import java.util.Calendar;

public class DiscountDemo {

    public static void main(String[] args) {
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
        Discount discountByTime = new DiscountByTimeDecorator(discount, user.getRegisteredDate());
        Discount discountByItemPurchased = new DiscountByItemsPurchasedDecorator(discount, user.getOrder().isGrocier());

        /*Discount discount = new EmployeeDiscount();

        Discount discountByBillAmount = new DiscountByBillAmountDecorator(discount, new BigDecimal(50));
        Discount discountByTime = new DiscountByTimeDecorator(discount, new Date());
        Discount discountByItemPurchased = new DiscountByItemsPurchasedDecorator(discount, false);

        int discountPercentage = discount.getDiscountPercentage();
        System.out.println(discountPercentage);*/

        int discountPercentage = discount.getDiscountPercentage();
        System.out.println("DiscountByBillAmountDecorator is " + ((DiscountByBillAmountDecorator) discountByBillAmount).isApply() + " with amount discount " + discountByBillAmount.getDiscountByAmount());
        System.out.println("DiscountByTimeDecorator is " + ((DiscountByTimeDecorator) discountByTime).isApply() + " with percentage added " + discountByTime.getDiscountPercentage());
        System.out.println("DiscountByItemsPurchasedDecorator " + ((DiscountByItemsPurchasedDecorator) discountByItemPurchased).isApply());

        System.out.println(discountPercentage);
    }
}
