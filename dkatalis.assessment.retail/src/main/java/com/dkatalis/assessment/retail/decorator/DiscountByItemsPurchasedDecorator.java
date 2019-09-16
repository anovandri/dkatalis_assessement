package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;

import java.math.BigDecimal;

public class DiscountByItemsPurchasedDecorator extends DiscountDecorator {

    private boolean isGrocier;
    private boolean apply;

    public DiscountByItemsPurchasedDecorator(Discount decoratedDiscount, boolean isGrocier) {
        super(decoratedDiscount);
        this.isGrocier = isGrocier;
        getDiscountPercentage();
    }

    @Override
    public int getDiscountPercentage() {
        if(isGrocier) {
            this.apply = true;
            decoratedDiscount.setDiscountPercentage(0);
        }
        return decoratedDiscount.getDiscountPercentage();
    }

    @Override
    public void setDiscountPercentage(int discountPercentage) {
        //do nothing
    }

    public boolean isApply() {
        return this.apply;
    }

    @Override
    public BigDecimal getDiscountByAmount() {
        //no operation
        return null;
    }

    @Override
    public void setDiscountByAmount(BigDecimal discountByAmount) {
        //no operation
    }
}
