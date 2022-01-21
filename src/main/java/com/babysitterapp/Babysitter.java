package com.babysitterapp;

public class Babysitter {

    // Bedtime may vary, needed for user input
    private final double bedtime;
    public Babysitter(double bedtime) {
        this.bedtime = bedtime;
    }

    public int calculateRate(double startTime, double endTime) {
        int rate = 0;
        // Taking into account the 24 hr clock
        if (endTime < 5) {
            endTime += 12;
        }
        // Add $12 to the rate for each hr worked before bedtime and end time
        while (futureStartTime(startTime) <= this.bedtime && futureStartTime(startTime) <= endTime) {
            startTime++;
            rate += 12;
        }
        // Add $8 to the rate for each hr worked before midnight and end time
        while (futureStartTime(startTime) <= 12 && futureStartTime(startTime) <= endTime) {
            startTime++;
            rate += 8;
        }
        // Add $16 to the rate for each hr worked after midnight and end time
        while (futureStartTime(startTime) <= 16 && futureStartTime(startTime) <= endTime) {
            startTime++;
            rate += 16;
        }
        return rate;
    }

    // Method that returns the start time with an added hour
    // To compare if a whole hour has been worked
    private double futureStartTime(double startTime) {
        return startTime + 1;
    }
}
