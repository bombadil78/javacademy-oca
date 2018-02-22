import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class PeriodVsDurationVsChronoUnit {

    private static void period() {
        Period tenDays = Period.ofDays(10);
        Period threeDay = Period.ofDays(3);
        Period sevenDays = tenDays.minus(threeDay);

        LocalDate today = LocalDate.now();
        LocalDate inSevenDays = today.plus(sevenDays);
    }

    private static void duration() {
        Duration someDuration = Duration.ofDays(1).plus(Duration.ofHours(7)).plus(Duration.ofMinutes(13));
        LocalDateTime someTime = LocalDateTime.now().minus(someDuration);
        System.out.println(someTime);
    }

    private static void chronoUnit() {
        long centuries = ChronoUnit.CENTURIES.between(LocalDate.now(), LocalDate.now().minus(Period.ofYears(200)));
        System.out.println(centuries);

        Instant now = Instant.now();
        Instant before36Hours = now.minus(Duration.ofHours(36));
        long noOfSeconds = ChronoUnit.SECONDS.between(before36Hours, now);
        System.out.println(noOfSeconds);
    }

    private static void exactAge() {
        LocalDate birthDay = LocalDate.of(1978, 8, 13);
        LocalDate today = LocalDate.now();

        Period period = Period.between(birthDay, today);
        long days = ChronoUnit.DAYS.between(birthDay, today);
        System.out.println(String.format("%d year, %d months, %d days (total %d days)", period.getYears(), period.getMonths(), period.getDays(), days));
    }

    private static void nextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthDay = LocalDate.of(Year.now().getValue(), 8, 13);

        Period period = Period.between(today, nextBirthDay);
        System.out.println(String.format("%d months and %d days left before your next birthday", period.getMonths(), period.getDays()));
    }

    private static void periodVsDuration() {
        Period oneDay = Period.ofDays(1); // + one day, same time
        Duration twentyFourHours = Duration.ofDays(1);  // + exactly 24 hours
    }

    public static void main(String[] args) {
        period();
        duration();
        chronoUnit();
        periodVsDuration();

        exactAge();
        nextBirthday();
    }
}
