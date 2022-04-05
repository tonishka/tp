package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.MeetingBook;
import seedu.address.model.meeting.Meeting;

/**
 * A utility class containing a list of {@code Meeting} objects to be used in tests.
 */
public class TypicalMeetings {

    public static final Meeting MEETING_1 = new MeetingBuilder().withAgenda("Paper supply for Greendale College")
            .withPlace("David's Office").withTime("02-04-2022 13:30").build();

    private TypicalMeetings() {} // prevents instantiation

    /**
     * Returns an {@code MeetingBook} with all the typical meetings.
     */
    public static MeetingBook getTypicalMeetingBook() {
        MeetingBook mb = new MeetingBook();
        for (Meeting meeting : getTypicalMeetings()) {
            mb.addMeeting(meeting);
        }
        return mb;
    }

    public static List<Meeting> getTypicalMeetings() {
        return new ArrayList<>(Arrays.asList(MEETING_1));
    }
}
