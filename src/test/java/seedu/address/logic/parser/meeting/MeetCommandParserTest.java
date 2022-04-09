package seedu.address.logic.parser.meeting;

import static seedu.address.logic.commands.CommandTestUtil.AGENDA_DESC_PROJECT;
import static seedu.address.logic.commands.CommandTestUtil.ATTENDEE_DESC_PROJECT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TIME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PLACE_DESC_PROJECT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;

import org.junit.jupiter.api.Test;

import seedu.address.model.meeting.MeetingTime;

public class MeetCommandParserTest {
    private MeetCommandParser meetCommandParser = new MeetCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {

    }

    @Test
    public void parse_invalidValue_failure() {
        // Invalid time
        assertParseFailure(meetCommandParser, ATTENDEE_DESC_PROJECT + AGENDA_DESC_PROJECT
                        + PLACE_DESC_PROJECT + INVALID_TIME_DESC,
                MeetingTime.MESSAGE_CONSTRAINTS);

        // Invalid agenda

        // Invalid attendees

        // Invalid place
    }

}
