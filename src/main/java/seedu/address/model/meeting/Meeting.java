package seedu.address.model.meeting;

import seedu.address.model.person.Person;

import java.util.HashSet;

/**
 * Represents a meeting of which the user is a part.
 */
public class Meeting {
    private final Agenda agenda;
    private final MeetingPlace place;
    private final MeetingTime time;
    private final HashSet<Person> attendees;

    public Meeting (Agenda agenda, MeetingPlace place, MeetingTime time, HashSet<Person> attendees) {
        this.agenda = agenda;
        this.place = place;
        this.time = time;
        this.attendees = attendees;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    public MeetingPlace getPlace() {
        return this.place;
    }

    public MeetingTime getTime() {
        return this.time;
    }

    public HashSet<Person> getAttendees() {
        return this.attendees;
    }

    /**
     * Returns true if both meetings have the same agenda, time, place and attendees.
     */
    public boolean isSameMeeting(Meeting otherMeeting) {
        if (otherMeeting == this) {
            return true;
        }

        return otherMeeting != null
                && otherMeeting.getAgenda().equals(getAgenda())
                && otherMeeting.getTime().equals(getTime())
                && otherMeeting.getPlace().equals(getPlace())
                && otherMeeting.getAttendees().equals(getAttendees());
    }
}
