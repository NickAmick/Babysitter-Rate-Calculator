package com.babysitterapp;

import com.babysitterapp.model.Babysitter;
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
        Assert.assertEquals("Rate for 9PM bedtime, work 5PM to 4AM, should be $136", expectedRate, actualRate);
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
        Assert.assertEquals("Rate for 9PM bedtime, work 5PM to 9PM, should be $48", expectedRate, actualRate);
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
        Assert.assertEquals("Rate for 9PM bedtime, work 6:15PM to 3AM, should be $96", expectedRate, actualRate);
    }

    @Test
    public void rate_for_1_bedtime_work_7_to_2_should_be_92() {
        // 7PM - bedtime 1AM is 5 hrs at $12/hr rate equals $60
        // Midnight - 2AM is 2 hrs at $16/hr equals $32
        // Total is $92

        // Arrange
        int expectedRate = 92;
        // Act
        babysitter = new Babysitter(1);
        int actualRate = babysitter.calculateRate(7, 2);
        // Assert
        Assert.assertEquals("Rate for 1AM bedtime, work 7PM to 2, should be $92", expectedRate, actualRate);
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
        Assert.assertEquals("Rate for 11:30PM bedtime, work 10PM to 12:30PM, should be $12", expectedRate, actualRate);
    }

    @Test
    public void rate_for_1030_bedtime_work_10_to_11_should_be_0() {
        // 10:00PM - bedtime 10:30 PM is 0 full hrs
        // 10:30PM - 11:00PM is 0 full hrs
        // Total is $0

        // Arrange
        int expectedRate = 0;
        // Act
        babysitter = new Babysitter(10.5);
        int actualRate = babysitter.calculateRate(10, 11);
        // Assert
        Assert.assertEquals("Rate for 10:30PM bedtime, work 10PM to 11PM should be 0", expectedRate, actualRate);
    }

    @Test
    public void rate_for_817_bedtime_work_617_to_1117_should_be_48() {
        // 6:17PM - bedtime 8:17PM is 2 full hrs at $12/hr equals $24
        // 8:17PM - 11:17 is 3 hrs at $8/hr equals $24
        // Total is $48

        // Arrange
        int expectedRate = 48;
        // Act
        babysitter = new Babysitter(8.0 + (17.0/60.0));
        int actualRate = babysitter.calculateRate(6.0 + (17.0/60.0), 11.0 + (17.0/60.0));
        // Assert
        Assert.assertEquals("Rate for 8:17PM bedtime, work 6:17PM to 11:17PM, should be $48", expectedRate, actualRate);
    }

    @Test
    public void rate_for_12_bedtime_work_705_to_1004_should_be_24() {
        // 7:05PM - end time 10:04PM is 2 full hrs at $12/hr equals $24
        // Total is $36

        // Arrange
        int expectedRate = 24;
        // Act
        babysitter = new Babysitter(12);
        int actualRate = babysitter.calculateRate(7.0 + (5.0/60.0), 10.0 + (4.0/60.0));
        // Assert
        Assert.assertEquals("Rate for 12:00PM bedtime, work 7:05PM to 10:04PM, should be $24", expectedRate, actualRate);
    }
}
