package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Meeting;

/**
 * Jackson-friendly version of {@link Meeting}.
 */
class JsonAdaptedMeeting {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Meeting's %s field is missing!";

    private final String agenda;
    private final String place;
    private final String time;
    private final List<JsonAdaptedAttendee> attendees = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedMeeting} with the given meeting details.
     */
    @JsonCreator
    public JsonAdaptedMeeting(@JsonProperty("agenda") String agenda,
                             @JsonProperty("place") String place,
                             @JsonProperty("time") String time,
                             @JsonProperty("attendeed") List<JsonAdaptedAttendee> attendees) {
        this.agenda = agenda;
        this.place = place;
        this.time = time;
        if (attendees != null) {
            this.attendees.addAll(attendees);
        }
    }

    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     */
    public JsonAdaptedMeeting(Meeting source) {
        agenda = source.getAgenda().agenda;
        place = source.getPlace().map(p -> p.place).orElse(null);
        time = source.getTime().map(t -> t.time).orElse(null);

        attendees.addAll(source.getAttendees().stream()
                .map(JsonAdaptedTag::new)
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

        if (!(place == null || Place.isValidPlace(place))) {
            throw new IllegalValueException(Place.MESSAGE_CONSTRAINTS);
        }

        final Place modelPlace = place != null ? new Place(place) : null;

        if (!(time == null || Time.isValidJobTime(time))) {
            throw new IllegalValueException(Time.MESSAGE_CONSTRAINTS);
        }

        final Time modelTime = time != null ? new Time(time) : null;

        final Set<Attendee> modelAttendees = new HashSet<>(attendees);

        return new Meeting(modelAgenda, modelTime, modelPlace, modelAttendees);
    }

    @Override
    public String toString() {
        return "JsonAdaptedMeeting{" +
                "agenda='" + agenda + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", attendees=" + attendees +
                '}';
    }
}
