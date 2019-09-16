package com.dkatalis.assessment.retail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_AffiliateDiscount {

    Discount discount;

    @Before
    public void initiate() {
        SetAffiliateDiscount setDiscount = new SetAffiliateDiscount();
        discount = setDiscount.setDiscount();
    }

    @Test
    public void test_getDiscountAmount() {
        Assert.assertEquals(0l, ((AffiliateDiscount) discount).getDiscountByAmount().longValue());
    }

    @Test
    public void test_getDiscountPercentage() {
        Assert.assertEquals(10, ((AffiliateDiscount) discount).getDiscountPercentage());
    }
}
