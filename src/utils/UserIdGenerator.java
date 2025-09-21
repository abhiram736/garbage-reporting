package utils;

import java.util.Random;
import java.time.Year;

public class UserIdGenerator {

    private static final Random random = new Random();

    // Generate user ID in format YYUSXXX
    public static String generateUserId() {
        // Get last two digits of current year
        int year = Year.now().getValue() % 100; // e.g., 2024 -> 24

        // Generate random 3-digit number (0-999)
        int randomNumber = random.nextInt(1000);

        // Format with leading zeros
        String formattedNumber = String.format("%03d", randomNumber);

        return year + "US" + formattedNumber;
    }

    // Optional: Overload to generate ID for a specific year
    public static String generateUserId(int fullYear) {
        int year = fullYear % 100;
        int randomNumber = random.nextInt(1000);
        String formattedNumber = String.format("%03d", randomNumber);
        return year + "US" + formattedNumber;
    }

    // Test

}
