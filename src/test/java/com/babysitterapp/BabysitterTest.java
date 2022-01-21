package com.babysitterapp;

import org.junit.*;

public class BabysitterTest {

    private Babysitter babysitter = new Babysitter();

    @Test
    public void calculate_rate_for_full_days_work_5_to_4() {
        // 5PM - 9PM is 4 hrs at $12/hr equals $48
        // 9PM - Midnight is 3 hrs at $8/hr equals $24
        // Midnight - 4AM is 4 hrs at $16/hr equals $64
        // Total is $136
        int actualRate = babysitter.calculateRate(5, 4);
        int expectedRate = 136;
        Assert.assertEquals(expectedRate, actualRate);
    }
}
