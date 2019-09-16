package com.dkatalis.assessment.retail;

public class Employee extends User {

    private Discount discount;

    public Discount getDiscount() {
        return new EmployeeDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
