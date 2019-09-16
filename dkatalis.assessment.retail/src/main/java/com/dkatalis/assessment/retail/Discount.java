package com.dkatalis.assessment.retail;

import java.math.BigDecimal;

public interface Discount {

    public int getDiscountPercentage();

    public void setDiscountPercentage(int discountPercentage);

    public BigDecimal getDiscountByAmount();

    public void setDiscountByAmount(BigDecimal discountByAmount);
}
