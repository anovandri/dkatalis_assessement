package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.Discount;

import java.math.BigDecimal;

public class DiscountByBillAmountDecorator extends DiscountDecorator {

    private static final Long PURCHASE_DISCOUNT_LIMIT = 100l;
    private static final Integer DISCOUNT_BY_BILL_AMOUNT = 5;
    private BigDecimal billAmount;

    private int discountPercentage;
    private BigDecimal discountByAmount;
    private boolean apply;

    public DiscountByBillAmountDecorator(Discount decoratedDiscount, BigDecimal billAmount) {
        super(decoratedDiscount);
        this.billAmount = billAmount;
        getDiscountByAmount();
    }

    @Override
    public int getDiscountPercentage() {
        //no operation
        return 0;
    }

    @Override
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public BigDecimal getDiscountByAmount() {
        this.discountByAmount = applyDiscountByAmountPurchased();
        if(discountByAmount.longValue() > 0) {
            this.apply = true;
            decoratedDiscount.setDiscountByAmount(applyDiscountByAmountPurchased());
        }
        return this.discountByAmount;
    }

    @Override
    public void setDiscountByAmount(BigDecimal discountByAmount) {
        this.discountByAmount = discountByAmount;
    }

    private BigDecimal applyDiscountByAmountPurchased() {
        if(this.billAmount.longValue() > PURCHASE_DISCOUNT_LIMIT) {
            int multiple = Math.toIntExact (this.billAmount.longValue() / PURCHASE_DISCOUNT_LIMIT);
            return new BigDecimal(DISCOUNT_BY_BILL_AMOUNT * multiple);
        }
        return new BigDecimal(0);
    }

    public boolean isApply() {
        return this.apply;
    }

}
