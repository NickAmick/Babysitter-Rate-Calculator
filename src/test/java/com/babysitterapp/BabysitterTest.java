package com.babysitterapp;

import org.junit.*;

public class BabysitterTest {

    private Babysitter babysitter;

    @Test
    public void rate_for_9_bedtime_work_5_to_4_should_be_136() {
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
        Assert.assertEquals("rate_for_9_bedtime_work_5_to_4_should_be_136", expectedRate, actualRate);
    }

    @Test
    public void rate_for_9_bedtime_work_5_to_9_should_be_48() {
        // 5PM - bedtime 9PM is 4 hrs at $12/hr equals $48

        // Arrange
        int expectedRate = 48;
        // Act
        babysitter = new Babysitter(9);
        int actualRate = babysitter.calculateRate(5, 9);
        // Assert
        Assert.assertEquals("rate_for_9_bedtime_work_5_to_9_should_be_48", expectedRate, actualRate);
    }

    @Test
    public void rate_for_9_bedtime_work_615_to_3_should_be_96() {
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
        Assert.assertEquals("rate_for_9_bedtime_work_615_to_3_should_be_96", expectedRate, actualRate);
    }

    @Test
    public void rate_for_7_bedtime_work_7_to_2_should_be_92() {
        // 7PM - bedtime 1AM is 5 hrs at $12/hr rate equals $60
        // Midnight - 2AM is 2 hrs at $16/hr equals $32
        // Total is $92

        // Arrange
        int expectedRate = 92;
        // Act
        babysitter = new Babysitter(1);
        int actualRate = babysitter.calculateRate(7, 2);
        // Assert
        Assert.assertEquals("rate_for_7_bedtime_work_7_to_2_should_be_92", expectedRate, actualRate);
    }

    @Test
    public void rate_for_1130_bedtime_work_10_to_1230_should_be_12() {
        // 10:00PM - bedtime 11:30PM is 1 full hr at $12/hr rate equals $12
        // 11:30PM - Midnight is 0 full hrs
        // Midnight - 12:30AM is 0 full hrs
        // Total is $12

        // Arrange
        int expectedRate = 12;
        // Act
        babysitter = new Babysitter(11.5);
        int actualRate = babysitter.calculateRate(10, 12.5);
        // Assert
        Assert.assertEquals("rate_for_7_bedtime_work_7_to_2_should_be_92", expectedRate, actualRate);
    }
}
