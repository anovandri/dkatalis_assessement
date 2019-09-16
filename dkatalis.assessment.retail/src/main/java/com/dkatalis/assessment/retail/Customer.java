package com.dkatalis.assessment.retail;

public class Customer extends User {

    private Discount discount;

    public Discount getDiscount() {
        return new CustomerDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
