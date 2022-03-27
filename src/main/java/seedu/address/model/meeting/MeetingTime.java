package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public static LocalDateTime formatTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter);
    }

    @Override
    public String toString() {
        return dateTime.format(formatter);
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
