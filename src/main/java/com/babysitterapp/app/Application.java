package com.babysitterapp.app;

import com.babysitterapp.model.Babysitter;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
        double startTime = 0;
        double bedtime = 0;
        double endTime = 0;
        boolean inUse = true;

        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("    Welcome to the babysitter rate calculator app!");
        System.out.println("    Please enter all times in hh:mm format");
        System.out.println();
        System.out.println("--------------------------------------------------------");

        while(inUse) {

            while (startTime == 0) {
                try {
                    System.out.println("Please enter your start time: ");
                    startTime = timeStringToDouble(input.nextLine());
                } catch (Exception ex) {
                    System.out.println("Please use hh:mm format, try again.");
                    System.out.println();
                }
            }

            while (bedtime == 0) {
                try {
                    System.out.println("Please enter the bedtime: ");
                    bedtime = timeStringToDouble(input.nextLine());
                } catch (Exception ex) {
                    System.out.println("Please use hh:mm format, try again.");
                    System.out.println();
                }
            }

            while (endTime == 0) {
                try {
                    System.out.println("Please enter your end time: ");
                    endTime = timeStringToDouble(input.nextLine());
                } catch (Exception ex) {
                    System.out.println("Please use hh:mm format, try again.");
                    System.out.println();
                }
            }

            Babysitter babysitter = new Babysitter(bedtime);

            System.out.println("----------------------------------------------");
            System.out.println("     Nightly charge: $" + babysitter.calculateRate(startTime, endTime));
            System.out.println("----------------------------------------------");

            System.out.println();
            System.out.println("Do you want to calculate another rate? (Y) or (N) ");
            String userChoiceToContinue = input.nextLine();

            if (userChoiceToContinue.equalsIgnoreCase("N")) {
                inUse = false;
            } else {
                startTime = 0;
                bedtime = 0;
                endTime = 0;
            }

        }
    }

    // Convert user input string to double
    public static double timeStringToDouble(String time) {
        String[] timeArray = time.split(":");
        double timeHour = Double.parseDouble(timeArray[0]);
        double timeMinutes = (Double.parseDouble(timeArray[1]) / 60);
        return timeHour + timeMinutes;
    }
}
