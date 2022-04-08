package seedu.address.logic.commands;

import seedu.address.model.meeting.EditMeetingDescriptor;
import seedu.address.testutil.EditMeetingDescriptorBuilder;

import static seedu.address.logic.parser.CliSyntax.PREFIX_AGENDA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PLACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

/**
 * Contains helper methods for testing commands involving a Meeting or Meetings.
 */
public class MeetingCommandTestUtil {

    public static final String VALID_AGENDA_QUARTERLY = "Quarterly meeting";
    public static final String VALID_AGENDA_PROJECT = "Project meeting";
    public static final String VALID_TIME_QUARTERLY = "01-01-2023 10:00";
    public static final String VALID_TIME_PROJECT = "28-05-2023 15:00";
    public static final String VALID_PLACE_QUARTERLY = "Conference Room #03-26";
    public static final String VALID_PLACE_PROJECT = "Study Room 3, Cambridge Hall";

    public static final String AGENDA_DESC_QUARTERLY = " " + PREFIX_AGENDA + VALID_AGENDA_QUARTERLY;
    public static final String AGENDA_DESC_PROJECT = " " + PREFIX_AGENDA + VALID_AGENDA_PROJECT;
    public static final String TIME_DESC_QUARTERLY = " " + PREFIX_TIME + VALID_TIME_QUARTERLY;
    public static final String TIME_DESC_PROJECT = " " + PREFIX_TIME + VALID_TIME_PROJECT;
    public static final String PLACE_DESC_QUARTERLY = " " + PREFIX_PLACE + VALID_PLACE_QUARTERLY;
    public static final String PLACE_DESC_PROJECT = " " + PREFIX_PLACE + VALID_PLACE_PROJECT;

    public static final String INVALID_AGENDA_DESC = " " + PREFIX_AGENDA + " "; // Agenda cannot be empty
    public static final String INVALID_TIME_DESC = " " + PREFIX_TIME + "15:00 01-01-2023"; //Wrong order of date & time
    public static final String INVALID_PLACE_DESC = " " + PREFIX_PLACE + " "; //Place cannot be empty

    public static final EditMeetingDescriptor DESC_QUARTERLY;
    public static final EditMeetingDescriptor DESC_PROJECT;

    static {
        DESC_QUARTERLY = new EditMeetingDescriptorBuilder().withAgenda(VALID_AGENDA_QUARTERLY)
                .withTime(VALID_TIME_QUARTERLY).withPlace(VALID_PLACE_QUARTERLY).build();
        DESC_PROJECT = new EditMeetingDescriptorBuilder().withAgenda(VALID_AGENDA_PROJECT).withTime(VALID_TIME_PROJECT)
                .withPlace(VALID_PLACE_PROJECT).build();
    }
}
