package com.dkatalis.assessment.retail;

import java.math.BigDecimal;

public class Order {

    private boolean isGrocier;
    private BigDecimal billAmount;
    private BigDecimal discountAmount;

    public boolean isGrocier() {
        return isGrocier;
    }

    public void setGrocier(boolean grocier) {
        isGrocier = grocier;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
}
