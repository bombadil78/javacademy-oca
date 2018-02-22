import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class Dates {

    private static void localDate() {
        LocalDate today = LocalDate.now();
        LocalDate myBirthdayIn2018 = LocalDate.of(2018, 8, 13);
        LocalDate firstSundayAfterMyBirthdayIn2018 = myBirthdayIn2018.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
    }

    private static void yearMonth() {
        YearMonth thisMonth = YearMonth.now();
        System.out.println(String.format(
                "%s has %d days",
                thisMonth.toString(),
                thisMonth.lengthOfMonth()
        ));
    }

    private static void monthDay() {
        MonthDay thisDay = MonthDay.now();
        boolean dayExistsInYear = thisDay.isValidYear(2000);
    }

    private static void year() {
        Year year = Year.now();
        boolean isLeapYear = year.isLeap();
    }

    public static void main(String[] args) {
        localDate();
        yearMonth();
        monthDay();
        year();
    }
}