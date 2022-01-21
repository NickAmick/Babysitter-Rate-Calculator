package com.babysitterapp;

public class Babysitter {

    // Bedtime is 9 PM

    public int calculateRate(double startTime, double endTime) {
        int rate = 0;
        // Add $12 to the rate for each hr worked before bedtime
        while (startTime < 9) {
            startTime++;
            rate += 12;
        }
        // Add $8 to the rate for each hr worked before midnight
        while (startTime < 12) {
            startTime++;
            rate += 8;
        }
        // Set value of start time to 0 to count for after midnight hours
        startTime = 0;
        // Add $16 to the rate for each hr worked after midnight
        while (startTime < 4) {
            startTime++;
            rate += 16;
        }
        return rate;
    }
}
