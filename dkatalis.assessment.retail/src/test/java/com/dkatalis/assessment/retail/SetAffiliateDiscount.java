package com.dkatalis.assessment.retail;

public class SetAffiliateDiscount {

    public Discount setDiscount() {
        Discount discount = new AffiliateDiscount();
        return discount;
    }
}
