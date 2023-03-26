package com.coding;

import java.util.stream.LongStream;

/**
 * Write a function, which takes a non-negative integer (seconds) as input and
 * returns the time in a human-readable format (HH:MM:SS)
 * 
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 **/
public class HumanReadableTime {

    public static void main(String[] args) {

        long[] seconds = new long[] { 359999, 7260, 3600 };

        LongStream.of(seconds)
                .forEach(e -> System.out.printf("%s = %s%n", e, convertHumanReadableTime(e)));
    }

    private static String convertHumanReadableTime(long input) {

        long scondsin1Hour = 3600;
        long scoundsin1Minute = 60;

        long HH = input / scondsin1Hour;
        long MM = (input % scondsin1Hour) / scoundsin1Minute;
        long SS = input % scoundsin1Minute;

        String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
        System.out.println("\n***Using String.format function =>"+ timeInHHMMSS);
        return new StringBuilder().append(HH).append(":")
                .append(MM).append(":")
                .append(SS)
                .toString();
    }

}