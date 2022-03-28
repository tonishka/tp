package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Represents the meeting time for a meeting.
 */
public class MeetingTime {
    public static final String MESSAGE_CONSTRAINTS =
            "Meeting time must be in the following format: dd-MM-yyyy HH:mm\n Example: 25-05-2022 23:59";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public final LocalDateTime dateTime;

    /**
     * Creates a new meeting time.
     * @param dateTime Meeting date and time.
     */
    public MeetingTime(LocalDateTime dateTime) {
        requireNonNull(dateTime);
        this.dateTime = dateTime;
    }

    /**
     * Returns true if a given string is a valid meeting time.
     */
    public static boolean isValidMeetingTime(String test) {
        try {
            LocalDateTime.parse(test, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Returns true if a given meeting has expired.
     */
    public boolean isExpiredMeetingTime() {
        return this.dateTime.isBefore(LocalDateTime.now());
    }

    public static LocalDateTime formatTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * Formats the time in a user-friendly 12-hour format.
     * @param dateTime
     * @return formatted time
     */
    public static String prettyTime(LocalDateTime dateTime) {
        String time = "11:59 PM"; // To bypass uninitialised string error
        try {
            String timeToFormat = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));
            SimpleDateFormat twentyFourHrFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat twelveHrFormat = new SimpleDateFormat("hh:mm a");
            Date dateToFormat = twentyFourHrFormat.parse(timeToFormat);
            time = twelveHrFormat.format(dateToFormat);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return time;
    }

    /**
     * Formats the date in a user-friendly manner.
     * @param dateTime
     * @return formatted date
     */
    public static String prettyDate(LocalDateTime dateTime) {
        String date = dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        return date;
    }

    @Override
    public String toString() {
        return dateTime.format(formatter);
    }

    public String toPrettyString() {
        return prettyDate(dateTime) + ", " + prettyTime(dateTime);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MeetingTime // instanceof handles nulls
                & dateTime.isEqual(((MeetingTime) other).dateTime)); // state check
    }

    @Override
    public int hashCode() {
        return dateTime.hashCode();
    }
}
