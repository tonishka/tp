package seedu.address.logic.commands.meeting;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_DUPLICATE_MEETING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ATTENDEES_INDEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_AGENDA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_PLACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_TIME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MEETINGS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.meeting.Agenda;
import seedu.address.model.meeting.EditMeetingDescriptor;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingPlace;
import seedu.address.model.meeting.MeetingTime;
import seedu.address.model.person.Person;

public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the meeting identified "
            + "by the index number used in the displayed meeting list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_ATTENDEES_INDEX + "LIST_OF_ATTENDEES_INDEX] "
            + "[" + PREFIX_MEETING_AGENDA + "AGENDA] "
            + "[" + PREFIX_MEETING_TIME + "MEETING_TIME] "
            + "[" + PREFIX_MEETING_PLACE + "MEETING PLACE] ";

    public static final String MESSAGE_UPDATE_MEETING_SUCCESS = "%1$s's information has been updated";
    public static final String MESSAGE_NOT_UPDATED = "At least one field to edit must be provided.";

    private final Index targetIndex;
    private final EditMeetingDescriptor editMeetingDescriptor;

    /**
     * @param targetIndex of the meeting in the filtered meeting list to edit
     * @param editMeetingDescriptor details to edit the meeting with
     */
    public UpdateCommand(Index targetIndex, EditMeetingDescriptor editMeetingDescriptor) {
        requireNonNull(targetIndex);
        requireNonNull(editMeetingDescriptor);

        this.targetIndex = targetIndex;
        this.editMeetingDescriptor = new EditMeetingDescriptor(editMeetingDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Meeting> lastShownMeetingList = model.getFilteredMeetingList();
        List<Person> lastShownPersonList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownMeetingList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MEETING_DISPLAYED_INDEX);
        }

        Meeting meetingToEdit = lastShownMeetingList.get(targetIndex.getZeroBased());
        Meeting editedMeeting = createEditedMeeting(meetingToEdit, editMeetingDescriptor, lastShownPersonList);

        if (!meetingToEdit.isSameMeeting(editedMeeting) && model.hasMeeting(editedMeeting)) {
            throw new CommandException(MESSAGE_DUPLICATE_MEETING);
        }

        model.setMeeting(meetingToEdit, editedMeeting);
        model.updateFilteredMeetingList(PREDICATE_SHOW_ALL_MEETINGS);
        return new CommandResult(String.format(MESSAGE_UPDATE_MEETING_SUCCESS, meetingToEdit));
    }

    /**
     * Creates and returns a {@code Meeting} with the details of {@code meetingToEdit}
     * edited with {@code editMeetingDescriptor}.
     */
    private static Meeting createEditedMeeting(Meeting meetingToEdit, EditMeetingDescriptor editMeetingDescriptor,
                                               List<Person> lastShownPersonList) {
        requireNonNull(meetingToEdit);

        Agenda updatedAgenda = editMeetingDescriptor.getAgenda().orElse(meetingToEdit.getAgenda());
        MeetingPlace updatedPlace = editMeetingDescriptor.getMeetingPlace().orElse(meetingToEdit.getPlace());
        MeetingTime updatedTime = editMeetingDescriptor.getMeetingTime().orElse(meetingToEdit.getTime());
        Set<Index> updatedAttendeesIndexes = editMeetingDescriptor.getAttendees()
                .orElse(meetingToEdit.getIndexes());
        Set<Person> updatedAttendees = new HashSet<>();
        for (Index index : updatedAttendeesIndexes) {
            if (index.getZeroBased() >= lastShownPersonList.size()) {
                LogsCenter.getLogger(MeetCommand.class).info(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            } else { //only add if valid
                updatedAttendees.add(lastShownPersonList.get(index.getZeroBased()));
            }
        }
        return new Meeting(updatedAgenda, updatedPlace, updatedTime, updatedAttendeesIndexes, updatedAttendees);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof UpdateCommand)) {
            return false;
        }

        // state check
        return targetIndex.equals(((UpdateCommand) other).targetIndex);
    }
}
