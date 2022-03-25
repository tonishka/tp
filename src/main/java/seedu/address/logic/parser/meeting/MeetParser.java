package seedu.address.logic.parser.meeting;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_AGENDA;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_PLACE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_TIME;

import java.util.Set;
import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.MeetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.meeting.Agenda;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingPlace;
import seedu.address.model.meeting.MeetingTime;

public class MeetParser implements Parser<MeetCommand> {
    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).anyMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Parses a string of argument into a MeetCommand. The information pertaining to a Meeting
     * is read and extracted out by the ParserUtil class and a Meeting object is created
     * from the extracted information.
     *
     * @param args arguments for a meeting
     * @return MeetCommand
     * @throws ParseException if there are no indexes or agenda in the arguments
     */
    public MeetCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer
                        .tokenize(args,
                                PREFIX_MEETING_AGENDA, PREFIX_MEETING_PLACE, PREFIX_MEETING_TIME);
        //A meeting should have an agenda but can leave
        //place and time empty if undecided
        if (!arePrefixesPresent(argMultimap, PREFIX_MEETING_AGENDA)
                || argMultimap.getPreamble().isEmpty()) { //throw error if no indexes added
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MeetCommand.MESSAGE_USAGE));
        }
        Set<Index> attendees = ParserUtil.parseAttendees(argMultimap.getPreamble());
        //return a Hashset of indexes and not a set of person since the model is only accessible inside the MeetCommand.
        //Inside the meetcommand is where the handling of out of bounds exceptions happens.
        Agenda agenda = ParserUtil.parseAgenda(argMultimap.getValue(PREFIX_MEETING_AGENDA).get());
        MeetingPlace meetingPlace = ParserUtil.parseMeetingPlace(argMultimap.getValue(PREFIX_MEETING_PLACE).get());
        MeetingTime meetingTime = ParserUtil.parseMeetingTime(argMultimap.getValue(PREFIX_MEETING_TIME).get());

        Meeting createdMeeting = new Meeting(agenda, meetingPlace, meetingTime, attendees);
        return new MeetCommand(createdMeeting);
    }

}
