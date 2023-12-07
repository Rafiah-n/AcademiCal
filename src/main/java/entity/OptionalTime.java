package entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code OptionalTime} class represents an optional date and time, allowing
 * for partial or complete specification of minute, hour, day of month, month, and year.
 * <p>
 * It provides methods to parse a string representation of a time and generate a
 * {@code LocalDateTime} object, as well as merge with another {@code OptionalTime} instance.
 * <p>
 * Default values are provided for unspecified fields.
 *
 * @author Leo (padril) Peckham
 * @version 1.0
 * @see LocalDateTime
 */
public class OptionalTime {
    final private static int   DEFAULT_NANO         = 0;   // should not be a field editable by user
    final private static int   DEFAULT_SECOND       = 0;   // should not be a field editable by user
    final private static int   DEFAULT_MINUTE       = 0;
    final private static int   DEFAULT_HOUR         = 12;  // noon
    final private static int   DEFAULT_DAY_OF_MONTH = 1;
    final private static Month DEFAULT_MONTH        = Month.JANUARY;
    final private static int   DEFAULT_YEAR         = 2023;

    private Optional<Integer> minute     = Optional.empty();
    private Optional<Integer> hour       = Optional.empty();
    private Optional<Integer> dayOfMonth = Optional.empty();
    private Optional<Month>   month      = Optional.empty();
    private Optional<Integer> year       = Optional.empty();

    private static final Pattern twelveHourMatch = Pattern.compile(
            "(0?[1-9]|1[0-2])[:h]?([0-5]\\d)?(?:[:.m][0-5]\\d)?\\w?(am|pm)", Pattern.CASE_INSENSITIVE);
    private static final Pattern twentyFourHourMatch = Pattern.compile(
            "([0-1]?\\d|2[0-3])[:h]([0-5]\\d)(?:[:.m][0-5]\\d)?", Pattern.CASE_INSENSITIVE);
    private static final Pattern dayOfMonthMatch = Pattern.compile("([0-2]?\\d|3[0-1])(?:st|nd|rd|th)?");
    private static final Pattern monthMatch = Pattern.compile(
            "(jan(?:uary)?|feb(?:ruary)?|mar(?:ch)?|apr(?:il)?|may|june?|july?|aug(?:ust)?|sep(?:tember)?|oct(?:ober)?|nov(?:ember)?|dec(?:ember)?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern yearMatch = Pattern.compile("((?:19|20)\\d{2})");

    /**
     * Constructs an {@code OptionalTime} instance by parsing the provided string
     * representation of time and populating the relevant fields.
     * <p>
     * The parsing supports various formats, including twelve-hour and twenty-four-hour
     * time, month abbreviations, and numerical day of month and year representations.
     * <p>
     * Default values are used for unspecified fields, and incomplete date information
     * can be later merged with another {@code OptionalTime} instance.
     *
     * @param string the string representation of time to parse
     * @see LocalDateTime
     */
    public OptionalTime(String string) {
        if (string.isBlank()) {
            return;
        }

        Matcher twelveHourMatcher     = twelveHourMatch.matcher(string);
        Matcher twentyFourHourMatcher = twentyFourHourMatch.matcher(string);
        Matcher dayOfMonthMatcher     = dayOfMonthMatch.matcher(string);
        Matcher monthMatcher          = monthMatch.matcher(string);
        Matcher yearMatcher           = yearMatch.matcher(string);

        // hour + minute
        if (twelveHourMatcher.find()) {
            System.out.println(twelveHourMatcher.group());
            hour = Optional.of(Integer.parseInt(twelveHourMatcher.group(1)));
            if (twelveHourMatcher.group(2) != null) {
                System.out.println(twelveHourMatcher.group(2));
                minute = Optional.of(Integer.parseInt(twelveHourMatcher.group(2)));
            }
            if (twelveHourMatcher.group(3).matches("(?i)am")) {
                if (hour.get() == 12) {
                    hour = Optional.of(0);
                }
            } else if (twelveHourMatcher.group(3).matches("(?i)pm")) {
                if (hour.get() != 12) {
                    hour = Optional.of(hour.get() + 12);
                }
            }
        } else if (twentyFourHourMatcher.find()) {
            hour = Optional.of(Integer.parseInt(twentyFourHourMatcher.group(1)));
            if (twentyFourHourMatcher.group(2) != null) {
                minute = Optional.of(Integer.parseInt(twentyFourHourMatcher.group(2)));
            }
        // month
        } else if (monthMatcher.find()) {
            Map<String, Month> monthAbbreviationMap = new HashMap<>();
            monthAbbreviationMap.put("JAN", Month.JANUARY);
            monthAbbreviationMap.put("FEB", Month.FEBRUARY);
            monthAbbreviationMap.put("MAR", Month.MARCH);
            monthAbbreviationMap.put("APR", Month.APRIL);
            monthAbbreviationMap.put("MAY", Month.MAY);
            monthAbbreviationMap.put("JUN", Month.JUNE);
            monthAbbreviationMap.put("JUL", Month.JULY);
            monthAbbreviationMap.put("AUG", Month.AUGUST);
            monthAbbreviationMap.put("SEP", Month.SEPTEMBER);
            monthAbbreviationMap.put("OCT", Month.OCTOBER);
            monthAbbreviationMap.put("NOV", Month.NOVEMBER);
            monthAbbreviationMap.put("DEC", Month.DECEMBER);

            month = Optional.of(monthAbbreviationMap.get(monthMatcher.group(1).toUpperCase().substring(0, 3)));
        // year
        } else if (yearMatcher.find()) {
            year = Optional.of(Integer.parseInt(yearMatcher.group(1)));
        // dayOfMonth
        } else if (dayOfMonthMatcher.find()) {
            dayOfMonth = Optional.of(Integer.parseInt(dayOfMonthMatcher.group(1)));
        }
    }

    // We don't need to get the values of these variables, but they need to be set if we have an incomplete date
    public void setMinute(Optional<Integer> minute) {
        this.minute = minute;
    }
    public void setHour(Optional<Integer> hour) {
        this.hour = hour;
    }
    public void setDayOfMonth(Optional<Integer> dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
    public void setMonth(Optional<Month> month) {
        this.month = month;
    }
    public void setYear(Optional<Integer> year) {
        this.year = year;
    }

    /**
     * Generates a {@code LocalDateTime} object based on the specified or default values
     * for year, month, day of month, hour, minute, and second.
     *
     * @return a {@code LocalDateTime} object representing the generated date and time
     * @see LocalDateTime
     */
    public LocalDateTime generateTime() {
        return LocalDateTime.of(
                year.orElse(DEFAULT_YEAR), month.orElse(DEFAULT_MONTH), dayOfMonth.orElse(DEFAULT_DAY_OF_MONTH),
                hour.orElse(DEFAULT_HOUR), minute.orElse(DEFAULT_MINUTE), DEFAULT_SECOND, DEFAULT_NANO);
    }

    /**
     * Merges the fields of this {@code OptionalTime} instance with another,
     * prioritizing values from the other instance when available.
     * <p>
     * Returns the values that went unused wrapped in an OptionalTime, so they
     * can be reused and chained together.
     *
     * @param other the {@code OptionalTime} instance to merge with
     * @return a new {@code OptionalTime} instance representing the merged values
     */
    public OptionalTime merge(OptionalTime other) {
        OptionalTime ret = new OptionalTime("");

        if (year.isPresent()       && other.year.isPresent())       ret.year = other.year;
        if (month.isPresent()      && other.month.isPresent())      ret.month = other.month;
        if (dayOfMonth.isPresent() && other.dayOfMonth.isPresent()) ret.dayOfMonth = other.dayOfMonth;
        if (hour.isPresent()       && other.hour.isPresent())       ret.hour = other.hour;
        if (minute.isPresent()     && other.minute.isPresent())     ret.minute = other.minute;

        if (year.isEmpty()       && other.year.isPresent())       year       = other.year;
        if (month.isEmpty()      && other.month.isPresent())      month      = other.month;
        if (dayOfMonth.isEmpty() && other.dayOfMonth.isPresent()) dayOfMonth = other.dayOfMonth;
        if (hour.isEmpty()       && other.hour.isPresent())       hour       = other.hour;
        if (minute.isEmpty()     && other.minute.isPresent())     minute     = other.minute;

        return ret;
    }
}
