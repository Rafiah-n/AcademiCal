package entity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            "(0?[1-9]|1[0-2])[:h]([0-5]\\d)?(?:[:.m][0-5]\\d)?\\w?(am|pm)", Pattern.CASE_INSENSITIVE);
    private static final Pattern twentyFourHourMatch = Pattern.compile(
            "([0-1]?\\d|2[0-3])[:h]([0-5]\\d)?(?:[:.m][0-5]\\d)?", Pattern.CASE_INSENSITIVE);
    private static final Pattern dayOfMonthMatch = Pattern.compile("([0-2]?\\d|3[0-1])(?:st|nd|rd|th)?");
    private static final Pattern monthMatch = Pattern.compile(
            "(jan(?:uary)?|feb(?:ruary)?|mar(?:ch)?|apr(?:il)?|may|june?|july?|aug(?:ust)?|sep(?:tember)?|oct(?:ober)?|nov(?:ember)?|dec(?:ember)?)", Pattern.CASE_INSENSITIVE);
    private static final Pattern yearMatch = Pattern.compile("((?:19|20)\\d{2})");

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
            System.out.println(twelveHourMatcher.namedGroups());
            hour = Optional.of(Integer.parseInt(twelveHourMatcher.group(1)));
            if (!Objects.equals(twelveHourMatcher.group(2), "")) {
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
            if (!Objects.equals(twentyFourHourMatcher.group(2), "")) {
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

    public LocalDateTime generateTime() {
        return LocalDateTime.of(
                year.orElse(DEFAULT_YEAR), month.orElse(DEFAULT_MONTH), dayOfMonth.orElse(DEFAULT_DAY_OF_MONTH),
                hour.orElse(DEFAULT_HOUR), minute.orElse(DEFAULT_MINUTE), DEFAULT_SECOND, DEFAULT_NANO);
    }

    public void merge(OptionalTime other) {
        if (other.year.isPresent())       year       = other.year;
        if (other.month.isPresent())      month      = other.month;
        if (other.dayOfMonth.isPresent()) dayOfMonth = other.dayOfMonth;
        if (other.hour.isPresent())       hour       = other.hour;
        if (other.minute.isPresent())     minute     = other.minute;
    }
}
