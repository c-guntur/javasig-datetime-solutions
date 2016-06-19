package javasig.hello.java.datetime;

import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * LocalDate, LocalTime, LocalDateTime and ZonedDateTime tests.
 * <p>
 * Note: We create a Clock instance in setup() used for some of the tests.
 *
 * @see Clock
 * @see Period
 * @see Duration
 * @see ChronoUnit
 */
public class Exercise3Test {
    private Clock terminatorOriginalJudgementDay = null;

    @Before
    public void setup() {

        Instant instant = Instant.parse("1997-08-29T07:14:30Z");
        // We make an assumption for GMT - 5 as the standard time for users of this test.
        terminatorOriginalJudgementDay = Clock.fixed(instant, ZoneId.of("GMT-5"));
    }

    @Test
    public void period() {

        // *****************************************************
        // Try using
        //                   either:
        // the fluent 'Period.ofXXX' and 'Period.with' methods
        // in tandem
        //                       or:
        // use the single 'of' method.
        // *****************************************************

        // Create a time period
        // TODO: Fix Period below to cover 20 years and 10 days.
//        fail("Delete this fail() and FIX using Period static utilities below.");
        Period twentyYearsAndTenDays = Period.of(20, 0, 10); // Period.ofYears(20).withDays(10);
        assertEquals("The Period should include twenty years", 20, twentyYearsAndTenDays.get(ChronoUnit.YEARS));
        assertEquals("The Period should include ten days", 10, twentyYearsAndTenDays.get(ChronoUnit.DAYS));


        // Add the Period to a LocalDateTime
        LocalDateTime tOJDateTime = LocalDateTime.now(terminatorOriginalJudgementDay);

//        fail("Delete this fail() and FIX LocalDateTime to use the created Period.");
        // TODO: Fix LocalDateTime below to add the 20 years and 10 days.
        //-----------------------------------------
        LocalDateTime calculatedTwentyYearsAndTenDaysLater = tOJDateTime.plus(twentyYearsAndTenDays); //tOJDateTime + Period.

        LocalDate twentyYearsAndTenDaysLaterDate = LocalDate.of(2017, 9, 8);
        assertEquals(twentyYearsAndTenDaysLaterDate.getYear(), calculatedTwentyYearsAndTenDaysLater.getYear());
        assertEquals(twentyYearsAndTenDaysLaterDate.getMonth(), calculatedTwentyYearsAndTenDaysLater.getMonth());
        assertEquals(twentyYearsAndTenDaysLaterDate.getDayOfMonth(), calculatedTwentyYearsAndTenDaysLater.getDayOfMonth());
    }

    @Test
    public void duration() {

        // *****************************************************
        // Try using
        //                   either:
        // the fluent 'Period.ofXXX' and 'Period.with' methods
        // in tandem
        //                       or:
        // use the single 'of' method.
        // *****************************************************

        // Create a time duration
        // TODO: Fix Period below to cover 3 hours and 6 seconds.
//        fail("Delete this fail() and FIX using Duration static utilities below.");
        Duration threeHoursAndSixSeconds = Duration.ofHours(3).plusSeconds(6); // Duration.of(10806, ChronoUnit.SECONDS);
        assertEquals(3, threeHoursAndSixSeconds.toHours());
        assertEquals(10806, threeHoursAndSixSeconds.getSeconds()); //Note: getSeconds gets full time.
        // NOTICE how the 'with'Seconds has a different meaning for Duration?


        // Add the Duration to a LocalDateTime
        LocalDateTime tOJDateTime = LocalDateTime.now(terminatorOriginalJudgementDay);

//        fail("Delete this fail() and FIX LocalDateTime to use the created Period.");
        // TODO: Fix LocalDateTime below to add the 3 hours and 6 seconds.
        //-----------------------------------------
        LocalDateTime calculatedThreeHoursAndSixSecondsLater = tOJDateTime.plus(threeHoursAndSixSeconds); //tOJDateTime + Duration.

        //7:14:30 GMT = 2:14:30 in (GMT-5). Adding 3h 6s = 5:14:36 in (GMT-5)
        LocalDateTime threeHoursAndSixSecondsLaterDate = tOJDateTime.withHour(5).withSecond(36);
        assertEquals(threeHoursAndSixSecondsLaterDate.getHour(), calculatedThreeHoursAndSixSecondsLater.getHour());
        assertEquals(threeHoursAndSixSecondsLaterDate.getMinute(), calculatedThreeHoursAndSixSecondsLater.getMinute());
        assertEquals(threeHoursAndSixSecondsLaterDate.getSecond(), calculatedThreeHoursAndSixSecondsLater.getSecond());
    }
}
