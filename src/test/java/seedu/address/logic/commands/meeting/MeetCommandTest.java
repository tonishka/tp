package seedu.address.logic.commands.meeting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.meeting.Meeting;
import seedu.address.testutil.MeetingBuilder;

public class MeetCommandTest {
    @Test
    public void constructor_nullMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MeetCommand(null));
    }

    @Test
    public void equals() {
        Meeting meetAlice = new MeetingBuilder().withAgenda("Meet Alice").build();
        Meeting meetMob = new MeetingBuilder().withAgenda("Meet Bob").build();
        MeetCommand meetAliceCommand = new MeetCommand(meetAlice);
        MeetCommand meetBobCommand = new MeetCommand(meetMob);

        // same object -> returns true
        assertTrue(meetAliceCommand.equals(meetAliceCommand));

        // same values -> returns true
        MeetCommand meetAliceCommandCopy = new MeetCommand(meetAlice);
        assertTrue(meetAliceCommand.equals(meetAliceCommandCopy));

        // different types -> returns false
        assertFalse(meetAliceCommand.equals(1));

        // null -> returns false
        assertFalse(meetAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(meetAliceCommand.equals(meetBobCommand));
    }
}
