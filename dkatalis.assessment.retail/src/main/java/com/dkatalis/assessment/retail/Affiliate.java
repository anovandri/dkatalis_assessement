package com.dkatalis.assessment.retail;

public class Affiliate extends User {

    private Discount discount;

    public Discount getDiscount() {
        return new AffiliateDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
