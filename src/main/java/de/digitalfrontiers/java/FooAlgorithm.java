package de.digitalfrontiers.java;

public class FooAlgorithm {
    public static boolean isValid(long number) {
        int sum = 0;
        boolean alternate = false;

        while (number > 0) {
            long digit = number % 10;
            if (alternate) {
                sum += 2 * digit;
                if (digit >= 5) {
                    sum -= 9;
                }
            } else {
                sum += digit;
            }
            number = number / 10;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }
}

