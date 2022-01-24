package com.babysitterapp.model;

public class Babysitter {

    // Bedtime may vary, needed for user input
    private double bedtime;

    // Variables to make magic numbers easier to read
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int FIVE = 5;
    private final int TWELVE = 12;
    private final int MIDNIGHT = 12;
    private final int SIXTEEN = 16;
    private final int EIGHT = 8;

    public Babysitter(double bedtime) {
        this.bedtime = bedtime;
    }

    /**
     * Returns an Integer (rate) representing the nightly charge for a
     * babysitter's given start time, the babies bedtime and the sitter's end time.
     * <p>
     * This method increments the rate by 12 for every full hour worked from start
     * time to end time, 8 for every full hour worked from bedtime to midnight and
     * 16 for every full hour worked from midnight to end of job.
     *
     * @param startTime double representing hour and minutes work began
     * @param endTime double representing hour and minutes work ended
     * @return Integer representing nightly charge in dollars
     */
    public int calculateRate(double startTime, double endTime) {

        int rate = ZERO;

        // Taking into account the 24 hr clock
        // When bedtime or end time is after midnight
        if (endTime < FIVE) {
            endTime += TWELVE;
        }
        if (getBedtime() < FIVE) {
            setBedtime(this.bedtime += TWELVE);
        }

        // Add $12 to the rate for each hr worked after start time - before bedtime and end time
        while (startTimePlusOneHr(startTime) <= getBedtime() && startTimePlusOneHr(startTime) <= endTime) {
            startTime++;
            rate += TWELVE;

            // Taking into account if the bedtime and end time is later than midnight
            // Breaking this pay loop for next pay rate
            if (startTimePlusOneHr(startTime) > MIDNIGHT) {
                // Setting start time to Midnight, accounting for non-full hours remaining
                startTime = MIDNIGHT;
                break;
            }
        }

        // Taking into account any non-full hours remaining once loop is broke
        // By start time plus one being greater than bedtime and not by end time or midnight
        // Setting start time equal to bedtime
        if (startTime < endTime) {
            startTime = getBedtime();
        }

        // Add $8 to the rate for each hr worked after bedtime - before midnight and end time
        while (startTimePlusOneHr(startTime) <= MIDNIGHT && startTimePlusOneHr(startTime) <= endTime) {
            startTime++;
            rate += EIGHT;
        }

        // Taking into account any non-full hours remaining once loop is broke
        // By start time plus one being greater than midnight, setting start time to midnight
        if (startTime < endTime) {
            startTime = MIDNIGHT;
        }

        // Add $16 to the rate for each hr worked after midnight and before end time
        while (startTimePlusOneHr(startTime) <= SIXTEEN && startTimePlusOneHr(startTime) <= endTime) {
            startTime++;
            rate += SIXTEEN;
        }
        return rate;
    }

    // Method that returns the start time with an added hour
    // To compare if a whole hour has been worked
    private double startTimePlusOneHr(double startTime) {
        return startTime + ONE;
    }

    public double getBedtime() {
        return bedtime;
    }

    public void setBedtime(double bedtime) {
        this.bedtime = bedtime;
    }
}
