package com.babysitterapp.app;

import com.babysitterapp.model.Babysitter;

import java.util.Scanner;

public class Application {

    public static double startTime = 0;
    public static double bedtime = 0;
    public static double endTime = 0;
    public static boolean inUse = true;
    public static final int EARLIEST_START_TIME = 5;
    public static Scanner input = new Scanner( System.in );

    public static void main(String[] args) {

        displayBanner();

        while(inUse) {

            while (startTime < EARLIEST_START_TIME) {
                startTime = getStartTime(startTime);
            }

            bedtime = getBedtime(bedtime);

            endTime = getEndTime(endTime);

            Babysitter babysitter = new Babysitter(bedtime);

            displayCalculatedRate(babysitter.calculateRate(startTime, endTime));

            inUse = calculateAnotherRateOrQuit();

            if (inUse) {
                startTime = resetTime();
                bedtime = resetTime();
                endTime = resetTime();
            }

        }
    }

    private static void displayBanner() {
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("    Welcome to the Babysitter Rate Calculator App!");
        System.out.println("    Give us a start time, bedtime, and an end time.");
        System.out.println("    And we will give you the rate you should charge!");
        System.out.println("    Please enter all times in hh:mm format");
        System.out.println();
        System.out.println("--------------------------------------------------------");
    }

    // Convert user input string to double
    private static double timeStringToDouble(String time) {
        String[] timeArray = time.split(":");
        double timeHour = Double.parseDouble(timeArray[0]);
        double timeMinutes = (Double.parseDouble(timeArray[1]) / 60);
        return timeHour + timeMinutes;
    }

    private static double getStartTime(double startTime) {
        while (startTime == 0) {
            try {
                System.out.println("Please enter your start time: ");
                startTime = timeStringToDouble(input.nextLine());
            } catch (Exception ex) {
                System.out.println("Please use hh:mm format, try again.");
                System.out.println();
            }
        }
        if (startTime < EARLIEST_START_TIME) {
            invalidStartTime();
            startTime = resetTime();
        }
        return startTime;
    }

    private static double getBedtime(double bedtime) {
        while (bedtime == 0) {
            try {
                System.out.println("Please enter the bedtime: ");
                bedtime = timeStringToDouble(input.nextLine());
            } catch (Exception ex) {
                System.out.println("Please use hh:mm format, try again.");
                System.out.println();
            }
        }
        return bedtime;
    }

    private static double getEndTime(double endTime) {
        while (endTime == 0) {
            try {
                System.out.println("Please enter your end time: ");
                endTime = timeStringToDouble(input.nextLine());
            } catch (Exception ex) {
                System.out.println("Please use hh:mm format, try again.");
                System.out.println();
            }
        }
        return endTime;
    }

    private static void displayCalculatedRate(double rate) {
        System.out.println("----------------------------------------------");
        System.out.println("     Nightly charge: $" + rate);
        System.out.println("----------------------------------------------");
    }

    private static boolean calculateAnotherRateOrQuit() {
        System.out.println();
        System.out.println("Do you want to calculate another rate? (Y) or (N) ");
        String userChoiceToContinue = input.nextLine();

        return userChoiceToContinue.equalsIgnoreCase("Y");
    }

    private static void invalidStartTime() {
        System.out.println("Note: cannot begin before 5PM. Please enter a valid start time.");
    }

    private static double resetTime() {
        return 0;
    }
}
