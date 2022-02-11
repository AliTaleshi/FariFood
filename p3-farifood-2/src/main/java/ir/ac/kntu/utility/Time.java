package ir.ac.kntu.utility;

import java.util.Objects;

public class Time {

    private int hour;

    private int minute;

    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time() {}

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int compare(Time time) { // If two times are equal method returns zero if bigger returns 1 and else returns -1
        if (this.hour > time.getHour()) {
            return 1;
        } else if (this.hour < time.getHour()) {
            return -1;
        }

        if (this.minute > time.getMinute()) {
            return 1;
        } else if (this.minute < time.getMinute()) {
            return -1;
        }

        if (this.second > time.getSecond()) {
            return 1;
        } else if (this.second < time.getSecond()) {
            return -1;
        }

        return 0; // If they were equal with each other
    }

    public Time changeIntoTime(String time) {
        String[] timeParts = time.split(":");
        Time time1 = new Time();
        time1.setHour(Integer.parseInt(timeParts[0]));
        time1.setMinute(Integer.parseInt(timeParts[1]));
        time1.setSecond(Integer.parseInt(timeParts[2]));
        return time1;
    }

    public void changeIntoTimeWithoutReturningTypeTime(String time) {
        String[] timeParts = time.split(":");
        this.setHour(Integer.parseInt(timeParts[0]));
        this.setMinute(Integer.parseInt(timeParts[1]));
        this.setSecond(Integer.parseInt(timeParts[2]));
    }

    public Time changeWorkingHourIntoStartingHour(String workingHour) {
        String[] strings = workingHour.split(" ");
        return changeIntoTime(strings[1]);
    }

    public Time changeWorkingHourIntoEndingHour(String workingHour) {
        String[] strings = workingHour.split(" ");
        return changeIntoTime(strings[3]);
    }

    public Time differenceBetweenTwoTimes(Time time1, Time time2) {
        Time period = new Time();

        int differenceInMilliSeconds = Math.abs(toMilliSeconds(time2) - toMilliSeconds(time1));

        period.setHour(differenceInMilliSeconds / (60 * 60 * 1000) % 24);

        period.setMinute((differenceInMilliSeconds / (60 * 1000)) % 60);

        period.setSecond((differenceInMilliSeconds / 1000) % 60);

        return period;
    }

    public int toMilliSeconds(Time time) {
        return (time.getHour() * 3600 * 1000) + (time.getMinute() * 60 * 1000) + (time.getSecond() * 1000);
    }

    public void milliSecondsToTime(int milliSeconds) {
        this.setHour((milliSeconds / (60 * 60 * 1000)) % 24);
        this.setMinute((milliSeconds / (60 * 1000)) % 60);
        this.setSecond((milliSeconds / 1000) % 60);
    }

    public Time setTimeByHour(int hour) {
        return new  Time(hour, 0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Time)) {
            return false;
        }

        Time time = (Time) o;
        return getHour() == time.getHour() && getMinute() == time.getMinute() && getSecond() == time.getSecond();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour=" + hour +
                ", minute=" + minute +
                ", second=" + second +
                '}';
    }
}
