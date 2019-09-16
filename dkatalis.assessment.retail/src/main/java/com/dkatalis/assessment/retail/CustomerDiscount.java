package com.dkatalis.assessment.retail;

import java.math.BigDecimal;

public class CustomerDiscount implements Discount {

    private int discountPercentage = 0;
    private BigDecimal discountByAmount = new BigDecimal(0);

    @Override
    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Override
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public BigDecimal getDiscountByAmount() {
        return this.discountByAmount;
    }

    @Override
    public void setDiscountByAmount(BigDecimal discountByAmount) {
        this.discountByAmount = discountByAmount;
    }
}
