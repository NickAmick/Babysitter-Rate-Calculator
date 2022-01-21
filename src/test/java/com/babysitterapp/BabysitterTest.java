package com.babysitterapp;

import org.junit.*;

public class BabysitterTest {

    private Babysitter babysitter;

    @Test
    public void calculate_rate_for_full_days_work_5_to_4() {
        // 5PM - bedtime 9PM is 4 hrs at $12/hr equals $48
        // 9PM - Midnight is 3 hrs at $8/hr equals $24
        // Midnight - 4AM is 4 hrs at $16/hr equals $64
        // Total is $136

        // Arrange
        int expectedRate = 136;
        // Act
        babysitter = new Babysitter(9);
        int actualRate = babysitter.calculateRate(5, 4);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void calculate_rate_for_half_night_work_5_to_9() {
        // 5PM - bedtime 9PM is 4 hrs at $12/hr equals $48

        // Arrange
        int expectedRate = 48;
        // Act
        babysitter = new Babysitter(9);
        int actualRate = babysitter.calculateRate(5, 9);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void calculate_rate_for_615_to_3() {
        // 6:15PM - bedtime 9PM is 2 full hrs at $12/hr equals $24
        // 9PM - Midnight is 3 hrs at $8/hr equals $24
        // Midnight - 3AM is 3 hrs at $16/hr equals $48
        // Total is $96

        // Arrange
        int expectedRate = 96;
        // Act
        babysitter = new Babysitter(9);
        int actualRate = babysitter.calculateRate(6.25, 3);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void calculate_rate_bedtime_1_shift_7_to_2() {
        // 7PM - bedtime 1AM is 5 hrs at $12/hr rate equals $60
        // Midnight - 2AM is 2 hrs at $16/hr equals $32
        // Total is $92

        // Arrange
        int expectedRate = 92;
        // Act
        babysitter = new Babysitter(1);
        int actualRate = babysitter.calculateRate(7, 2);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }
}
