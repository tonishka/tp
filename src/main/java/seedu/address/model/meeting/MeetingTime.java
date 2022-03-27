package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents the meeting time for a meeting.
 */
public class MeetingTime {
    public static final String MESSAGE_CONSTRAINTS =
            "Meeting time must be in the following format: YYYY-MM-dd HH:mm\n Example: 2022-05-25 23:59";
    public final LocalDateTime dateTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /**
     * Creates a new meeting time.
     * @param dateTime Meeting date and time.
     */
    public MeetingTime(LocalDateTime dateTime) {
        requireNonNull(dateTime);
        checkArgument(isValidMeetingTime(String.valueOf(dateTime)), MESSAGE_CONSTRAINTS);
        this.dateTime = dateTime;
    }

    /**
     * Returns true if a given string is a valid meeting time.
     */
    public static boolean isValidMeetingTime(String test) {
        try {
            LocalDateTime.parse(test, formatter);
            return true;
        } catch (DateTimeParseException e){
            return false;
        }
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
