package com.dkatalis.assessment.retail;

import java.math.BigDecimal;

public class SetOrder {

    public Order setOrder() {
        Order order = new Order();
        order.setGrocier(true);
        order.setBillAmount(new BigDecimal(990));
        order.setDiscountAmount(new BigDecimal(10));
        return order;
    }
}
