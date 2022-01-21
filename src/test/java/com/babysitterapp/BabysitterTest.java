package com.babysitterapp;

import org.junit.*;

public class BabysitterTest {

    private final Babysitter babysitter = new Babysitter();

    @Test
    public void calculate_rate_for_full_days_work_5_to_4() {
        // 5PM - 9PM is 4 hrs at $12/hr equals $48
        // 9PM - Midnight is 3 hrs at $8/hr equals $24
        // Midnight - 4AM is 4 hrs at $16/hr equals $64
        // Total is $136

        // Arrange
        int expectedRate = 136;
        // Act
        int actualRate = babysitter.calculateRate(5, 4);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void calculate_rate_for_half_night_work_5_to_9() {
        // 5PM - 9PM is 4 hrs at $12/hr equals $48

        // Arrange
        int expectedRate = 48;
        // Act
        int actualRate = babysitter.calculateRate(5, 9);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }

    @Test
    public void calculate_rate_for_615_to_3() {
        // 6:15PM - 9PM is 2 full hrs at $12/hr equals $24
        // 9PM - Midnight is 3 hrs at $8/hr equals $24
        // Midnight - 3AM is 3 hrs at $16/hr equals $48
        // Total is $96

        // Arrange
        int expectedRate = 96;
        // Act
        int actualRate = babysitter.calculateRate(6.25, 3);
        // Assert
        Assert.assertEquals(expectedRate, actualRate);
    }
}
