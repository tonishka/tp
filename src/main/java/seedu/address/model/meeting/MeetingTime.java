package seedu.address.model.meeting;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents the meeting time for a meeting.
 */
public class MeetingTime {
    public static final String MESSAGE_CONSTRAINTS =
            "Meeting time must be in the following format: YYYY-MM-dd HH:mm\n Example: 2022-05-25 23:59";
    public final LocalDateTime dateTime;
    private final DateTimeFormatter formatter;

    /**
     * Creates a new meeting time
     * @param dateTime
     */
    public MeetingTime(LocalDateTime dateTime) {
        requireNonNull(dateTime);
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        String formatted = dateTime.format(formatter);
        return formatted;
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
