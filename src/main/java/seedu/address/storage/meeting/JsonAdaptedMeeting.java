package seedu.address.storage.meeting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.meeting.Agenda;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.meeting.MeetingPlace;
import seedu.address.model.meeting.MeetingTime;

/**
 * Jackson-friendly version of {@link Meeting}.
 */
class JsonAdaptedMeeting {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Meeting's %s field is missing!";

    private final String agenda;
    private final String meetingPlace;
    private final String meetingTime;
    private final List<JsonAdaptedAttendee> attendees = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedMeeting} with the given meeting details.
     */
    @JsonCreator
    public JsonAdaptedMeeting(@JsonProperty("agenda") String agenda,
                             @JsonProperty("meetingPlace") String meetingPlace,
                             @JsonProperty("meetingTime") String meetingTime,
                             @JsonProperty("attendees") List<JsonAdaptedAttendee> attendees) {
        this.agenda = agenda;
        this.meetingPlace = meetingPlace;
        this.meetingTime = meetingTime;
        if (attendees != null) {
            this.attendees.addAll(attendees);
        }
    }

    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     */
    public JsonAdaptedMeeting(Meeting source) {
        agenda = source.getAgenda().description;
        meetingPlace = source.getPlace().place;
        meetingTime = String.valueOf(source.getTime().dateTime);

        attendees.addAll(source.getAttendees().stream()
                .map(JsonAdaptedAttendee::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Meeting toModelType() throws IllegalValueException {
        if (agenda == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "agenda"));
        }
        if (!Agenda.isValidAgenda(agenda)) {
            throw new IllegalValueException(Agenda.MESSAGE_CONSTRAINTS);
        }
        final Agenda modelAgenda = new Agenda(agenda);

        if (!(meetingPlace == null || MeetingPlace.isValidMeetingPlace(meetingPlace))) {
            throw new IllegalValueException(MeetingPlace.MESSAGE_CONSTRAINTS);
        }

        final MeetingPlace modelPlace = meetingPlace != null ? new MeetingPlace(meetingPlace) : null;

        if (!(meetingTime == null || MeetingTime.isValidMeetingTime(meetingTime))) {
            throw new IllegalValueException(MeetingTime.MESSAGE_CONSTRAINTS);
        }

        final MeetingTime modelTime = meetingTime != null ? new MeetingTime(MeetingTime.formatTime(meetingTime)) : null;

        final Set<Attendee> modelAttendees = new HashSet<>(attendees);

        return new Meeting(modelAgenda, modelPlace, modelTime, modelAttendees);
    }

    @Override
    public String toString() {
        return "JsonAdaptedMeeting{" +
                "agenda='" + agenda + '\'' +
                ", place='" + meetingPlace + '\'' +
                ", time='" + meetingTime + '\'' +
                ", attendees=" + attendees +
                '}';
    }
}
