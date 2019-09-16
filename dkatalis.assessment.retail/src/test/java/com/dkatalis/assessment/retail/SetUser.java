package com.dkatalis.assessment.retail;

import java.util.Date;

public class SetUser {

    public User setUser() {
        User user = new Employee();
        user.setName("Anovandri");
        user.setAddress("Depok");
        user.setRegisteredDate(new Date());
        return user;
    }
}
