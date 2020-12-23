import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NextDayCalculatorTest {

    @org.junit.jupiter.api.Test
    void findNextDay() {
        int day = 12;
        int month = 2;
        int year = 2020;
        int nextDay = day + 1;
        String expected = "The NextDay is: " + nextDay + "/" + month + "/" + year;

        String result = NextDayCalculator.findNextDay(day, month, year);
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void lastDayOfMonth() {
        int month = 2;
        int year = 2020;
        int expected = 29;

        int result = NextDayCalculator.lastDayOfMonth(month, year);
        assertEquals(expected, result);
    }

    @Test
    void checkDay() {
        int day = 29;
        int month = 2;
        int year = 2020;
        boolean expected = true;
        boolean result = NextDayCalculator.checkDay(day, month, year);

        assertEquals(expected, result);
    }


}