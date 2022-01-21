package com.babysitterapp;

import org.junit.*;

public class BabysitterTest {

    private Babysitter babysitter = new Babysitter();

    @Test
    public void calulate_rate_for_full_days_work_5_to_4() {
        int actualRate = babysitter.calculateRate(5, 4);
        int expectedRate = 0;
        Assert.assertEquals(actualRate, expectedRate);
    }
}
