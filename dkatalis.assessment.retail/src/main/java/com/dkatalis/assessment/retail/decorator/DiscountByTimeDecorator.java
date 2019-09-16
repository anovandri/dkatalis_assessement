package com.dkatalis.assessment.retail.decorator;

import com.dkatalis.assessment.retail.CustomerDiscount;
import com.dkatalis.assessment.retail.Discount;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class DiscountByTimeDecorator extends DiscountDecorator {

    private static final Integer YEAR_VALIDATION = -2;
    private static final Integer DISCOUNT_BY_TIME_PERCENTAGE = 5;

    private Date registeredDate;
    private int discountPercentage;
    private boolean apply;

    public DiscountByTimeDecorator(Discount decoratedDiscount, Date registeredDate) {
        super(decoratedDiscount);
        this.registeredDate = registeredDate;
        getDiscountPercentage();
    }

    @Override
    public int getDiscountPercentage() {
        this.discountPercentage = applyDiscountByTime();
        if(this.discountPercentage > 0) {
            this.apply = true;
            decoratedDiscount.setDiscountPercentage(this.discountPercentage);
        }
        return this.discountPercentage;
    }

    @Override
    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    private int applyDiscountByTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, YEAR_VALIDATION);
        if(calendar.getTime().after(this.registeredDate) && decoratedDiscount instanceof CustomerDiscount) {
            return DISCOUNT_BY_TIME_PERCENTAGE;
        }
        return 0;
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

    public boolean isApply() {
        return this.apply;
    }

}
