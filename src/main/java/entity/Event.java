package entity;

import java.time.*;
import java.util.Optional;

public abstract class Event {

    final private static int   DEFAULT_NANO         = 0;   // should not be a field editable by user
    final private static int   DEFAULT_SECOND       = 0;   // should not be a field editable by user
    final private static int   DEFAULT_MINUTE       = 0;
    final private static int   DEFAULT_HOUR         = 12;  // noon
    final private static int   DEFAULT_DAY_OF_MONTH = 1;
    final private static Month DEFAULT_MONTH        = Month.JANUARY;
    final private static int   DEFAULT_YEAR         = 2023;

    private Optional<Integer> optStartMinute     = Optional.empty();
    private Optional<Integer> optStartHour       = Optional.empty();
    private Optional<Integer> optStartDayOfMonth = Optional.empty();
    private Optional<Month>   optStartMonth      = Optional.empty();
    private Optional<Integer> optStartYear       = Optional.empty();
    private Optional<Integer> optEndMinute       = Optional.empty();
    private Optional<Integer> optEndHour         = Optional.empty();
    private Optional<Integer> optEndDayOfMonth   = Optional.empty();
    private Optional<Month>   optEndMonth        = Optional.empty();
    private Optional<Integer> optEndYear         = Optional.empty();
    private String name;
    private Course course;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Location location;
    private Boolean completed;

    // We don't need to get the values of these variables, but they need to be set if we have an incomplete date
    public void setOptStartMinute(Optional<Integer> optStartMinute) {
        this.optStartMinute = optStartMinute;
    }
    public void setOptStartHour(Optional<Integer> optStartHour) {
        this.optStartHour = optStartHour;
    }
    public void setOptStartDayOfMonth(Optional<Integer> optStartDayOfMonth) {
        this.optStartDayOfMonth = optStartDayOfMonth;
    }
    public void setOptStartMonth(Optional<Month> optStartMonth) {
        this.optStartMonth = optStartMonth;
    }
    public void setOptStartYear(Optional<Integer> optStartYear) {
        this.optStartYear = optStartYear;
    }
    public void setOptEndMinute(Optional<Integer> optEndMinute) {
        this.optEndMinute = optEndMinute;
    }
    public void setOptEndHour(Optional<Integer> optEndHour) {
        this.optEndHour = optEndHour;
    }
    public void setOptEndDayOfMonth(Optional<Integer> optEndDayOfMonth) {
        this.optEndDayOfMonth = optEndDayOfMonth;
    }
    public void setOptEndMonth(Optional<Month> optEndMonth) {
        this.optEndMonth = optEndMonth;
    }
    public void setOptEndYear(Optional<Integer> optEndYear) {
        this.optEndYear = optEndYear;
    }

    public LocalDateTime generateStartTimeFromOpt() {
        return generateTimeFromOpt(optStartMinute, optStartHour, optStartDayOfMonth, optStartMonth, optStartYear);
    }

    public LocalDateTime generateEndTimeFromOpt() {
        return generateTimeFromOpt(optEndMinute, optEndHour, optEndDayOfMonth, optEndMonth, optEndYear);
    }

    private LocalDateTime generateTimeFromOpt(Optional<Integer> optEndMinute, Optional<Integer> optEndHour,
                                              Optional<Integer> optEndDayOfMonth, Optional<Month> optEndMonth,
                                              Optional<Integer> optEndYear) {
        int   minute       = optEndMinute.orElse(DEFAULT_MINUTE);
        int   hour         = optEndHour.orElse(DEFAULT_HOUR);
        int   dayOfMonth   = optEndDayOfMonth.orElse(DEFAULT_DAY_OF_MONTH);
        Month month        = optEndMonth.orElse(DEFAULT_MONTH);
        int   year         = optEndYear.orElse(DEFAULT_YEAR);

        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, DEFAULT_SECOND, DEFAULT_NANO);
    }


    public String getName() {
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public Course getCourse() {
        return course;
    }
    public void setCourse(Course c){
        course = c;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime time){
        startTime = time;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime time){
        endTime = time;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location loc){
        location = loc;
    }

    public boolean getCompleted() {
        return completed;
    }
    public void setCompleted(boolean compl){
        completed = compl;
    }
}
