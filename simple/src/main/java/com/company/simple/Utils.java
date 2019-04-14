package com.company.simple;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String generateINN() {
        int numbers[] = new int[12];

        numbers[0] = 7;
        numbers[1] = 7;

        for (int j = 2; j < 10; j++) {
            numbers[j] = getRandomNumberInRange(0, 9);
        }

        numbers[10] = ((numbers[0] * 7 + numbers[1] * 2 + numbers[2] * 4 + numbers[3] * 10 + numbers[4] * 3 + numbers[5] * 5 + numbers[6] * 9 + numbers[7] * 4 + numbers[8] * 6 + numbers[9] * 8) % 11) % 10;
        numbers[11] = ((numbers[0] * 3 + numbers[1] * 7 + numbers[2] * 2 + numbers[3] * 4 + numbers[4] * 10 + numbers[5] * 3 + numbers[6] * 5 + numbers[7] * 9 + numbers[8] * 4 + numbers[9] * 6 + numbers[10] * 8) % 11) % 10;

        StringBuilder result = new StringBuilder();

        for (int number : numbers) {
            result.append(Integer.toString(number));
        }

        return result.toString();
    }

    public static LocalDate randomBirthday(int yearMin, int yearMax) {
        Random random = new Random();

        int minDay = (int) LocalDate.of(yearMin, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(yearMax, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static String formatDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
