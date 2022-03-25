package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_AGENDA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_PLACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_TIME;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.person.Person;

/**
 * Creates a new meeting for the user.
 */
public class MeetCommand extends Command {

    public static final String COMMAND_WORD = "meet";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":Adds a new meeting.\n"
            + "Required Parameters: "
            + "[INDEX OF PERSON IN REACHE] [MORE INDICES OF PEOPLE IN REACHE]..."
            + PREFIX_MEETING_AGENDA + "AGENDA "

            + PREFIX_MEETING_PLACE + "MEETING PLACE "
            + PREFIX_MEETING_TIME + "MEETING TIME\n"
            + "Example: " + COMMAND_WORD + " "
            + "1 3 5 67 "
            + PREFIX_MEETING_AGENDA + "Product Demo with Client "
            + PREFIX_MEETING_PLACE + "Conference Room 5A "
            + PREFIX_MEETING_TIME + "2022-04-05 15:44";

    public static final String MESSAGE_SUCCESS = "Created a new meeting: %1$s";

    private final Meeting toMeet;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public MeetCommand(Meeting meeting) {
        requireNonNull(meeting);
        toMeet = meeting;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        Set<Person> attendees = new HashSet<>();
        for (Index index : toMeet.getIndexes()) {
            if (index.getZeroBased() >= lastShownList.size()) {
                throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            }
            attendees.add(lastShownList.get(index.getZeroBased()));
        }
        Meeting meetingWithAttendeesAdded = toMeet.setAttendees(attendees);
        return new CommandResult(String.format(MESSAGE_SUCCESS, meetingWithAttendeesAdded), false, false,
                true,
                false, false, null);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MeetCommand // instanceof handles nulls
                && toMeet.equals(((MeetCommand) other).toMeet));
    }

    @Override
    public String toString() {
        return "New meeting: " + toMeet.getAgenda().toString();
    }
}