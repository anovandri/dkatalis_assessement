package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;

public abstract class DiscountDecorator implements Discount {

    protected Discount decoratedDiscount;

    public DiscountDecorator(Discount decoratedDiscount) {
        this.decoratedDiscount = decoratedDiscount;
    }
}
